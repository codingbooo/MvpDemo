package codingbo.mvpdemo.download;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by bob
 * on 17.2.8.
 */

public class DownloadStatusConvert implements PropertyConverter<DownloadStatus, Integer> {

    @Override
    public DownloadStatus convertToEntityProperty(Integer databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        for (DownloadStatus status : DownloadStatus.values()) {
            if (status.id == databaseValue) {
                return status;
            }
        }
        return DownloadStatus.NOT_DOWNLOAD;
    }

    @Override
    public Integer convertToDatabaseValue(DownloadStatus entityProperty) {
        return entityProperty == null ? null : entityProperty.id;
    }
}