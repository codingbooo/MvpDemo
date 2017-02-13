package codingbo.downloadui.download;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import codingbo.downloadui.R;

/**
 * Created by bob
 * on 17.2.10.
 */

public class DownloadAdapter extends BaseAdapter {

    private List<DownloadInfo> mData;

    public DownloadAdapter(List<DownloadInfo> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public DownloadInfo getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<DownloadInfo> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        DownloadInfo info = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_item, parent, false);
            holder = new ViewHolder();
            holder.mProgressBar = (ProgressBar) convertView.findViewById(R.id.pb_progress);
            holder.mTvName = (TextView) convertView.findViewById(R.id.tv_Name);
            holder.mTvProgress = (TextView) convertView.findViewById(R.id.tv_progress);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTvName.setText(info.getName());
        holder.mProgressBar.setProgress((int) info.getProgress());
        holder.mTvProgress.setText(info.getProgress() + "%");
//        holder.mTvProgress.setText(parent.getContext().getResources().getText(R.string.progress_info));

        return convertView;
    }

    class ViewHolder {
        TextView mTvName;
        TextView mTvProgress;
        ProgressBar mProgressBar;
    }
}
