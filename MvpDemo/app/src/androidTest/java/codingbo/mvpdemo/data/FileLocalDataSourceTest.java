package codingbo.mvpdemo.data;

import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import codingbo.mvpdemo.download.DownloadStatus;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by bob
 * on 17.2.9.
 */
public class FileLocalDataSourceTest {

    private FileLocalDataSource mSource;

    @Before
    public void setUp() throws Exception {
        mSource = FileLocalDataSource.getInstance(
                InstrumentationRegistry.getTargetContext()
        );
    }

    @After
    public void tearDown() throws Exception {
        mSource.deleteAllFiles();
    }

    /**
     * 测试保存数据,并通过查找方法验证保存
     */
    @Test
    public void save_retrievesFile() {
        final FileInfo fileInfo = new FileInfo("123-abc", "adb.doc", 0, DownloadStatus.NOT_DOWNLOAD);
        final FileInfo f2 = new FileInfo("123-abc-456", "adb.doc", 0, DownloadStatus.NOT_DOWNLOAD);

        mSource.saveFile(fileInfo);
        mSource.saveFile(f2);

        mSource.getFile(fileInfo.getFileId(), new FileDataSource.GetFileCallback() {
            @Override
            public void onFilesLoaded(FileInfo file) {
                assertThat(file, is(fileInfo));
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Test
    public void completed_retrievesCompleted() {
        final FileInfo f1 = new FileInfo("123-abc", "adb.doc", 0, DownloadStatus.NOT_DOWNLOAD);
        mSource.saveFile(f1);
        mSource.downloadComplete(f1.getFileId());
        mSource.updateProgress(f1.getFileId(), 20);

        mSource.getFile(f1.getFileId(), new FileDataSource.GetFileCallback() {
            @Override
            public void onFilesLoaded(FileInfo files) {
                assertThat(files, is(f1));
                assertEquals(DownloadStatus.COMPLETED, files.getDownloadStatus());
                assertEquals(20.0, files.getProgress(), 0);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Test
    public void loading_retrievesCompleted() {
        FileDataSource.GetFileCallback callback = mock(FileDataSource.GetFileCallback.class);
        final FileInfo f1 = new FileInfo("123-abc", "adb.doc", 0, DownloadStatus.NOT_DOWNLOAD);
        ArgumentCaptor<FileInfo> argumentCaptor = ArgumentCaptor.forClass(FileInfo.class);

        mSource.saveFile(f1);
        mSource.downloading(f1.getFileId());
        mSource.getFile(f1.getFileId(), callback);

        verify(callback, never()).onDataNotAvailable();

        verify(callback).onFilesLoaded(argumentCaptor.capture());

        List<FileInfo> values = argumentCaptor.getAllValues();

        assertThat(DownloadStatus.DOWNLOADING, is(values.get(0).getDownloadStatus()));
    }

    @Test
    public void notDownload_retrievesCompleted() {
        FileDataSource.GetFileCallback callback = mock(FileDataSource.GetFileCallback.class);

        final FileInfo f1 = new FileInfo("123-abc", "adb.doc", 0, DownloadStatus.NOT_DOWNLOAD);

        mSource.saveFile(f1);
        mSource.downloadFailed(f1.getFileId());
        mSource.getFile(f1.getFileId(), callback);

        verify(callback).onFilesLoaded(f1);
        verify(callback, never()).onDataNotAvailable();
        assertThat(DownloadStatus.DOWNLOAD_FAILED, is(f1.getDownloadStatus()));
    }


}