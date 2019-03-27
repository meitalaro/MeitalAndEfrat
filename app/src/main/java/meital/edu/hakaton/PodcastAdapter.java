package meital.edu.hakaton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {
    List<Podcast> pods;
    Context context;

    public PodcastAdapter(List<Podcast> pods, Context context) {
        this.pods = pods;
        this.context = context;
    }

    @NonNull
    @Override
    public PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.podcast_item, parent, false);
        //LayoutInflater inflater = LayoutInflater.from(context);
        return new PodcastViewHolder(v);

    }
    @Override
    public void onBindViewHolder(@NonNull PodcastAdapter.PodcastViewHolder holder, int position) {
        Podcast podcast = pods.get(position);

        holder.tvStreamName.setText(podcast.getStreamName());
        holder.tvVodName.setText(podcast.getVodName());
        holder.tvStreamId.setText(podcast.getStreamId());
        holder.tvCreationDate.setText(podcast.getCreationDate());
        holder.tvDuration.setText(podcast.getDuration());
        holder.tvFileSize.setText(podcast.getFileSize());
        holder.tvFilePath.setText(podcast.getFilePath());
        holder.tvVodId.setText(podcast.getVodId());
        holder.tvType.setText(podcast.getType());

    }

    @Override
    public int getItemCount() {
        return pods.size();
    }

    class PodcastViewHolder extends RecyclerView.ViewHolder {
        TextView tvStreamName;
        TextView tvVodName;
        TextView tvStreamId;
        TextView tvCreationDate;
        TextView tvDuration;
        TextView tvFileSize;
        TextView tvFilePath;
        TextView tvVodId;
        TextView tvType;

        public PodcastViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStreamName = itemView.findViewById(R.id.tvStreamName);
            tvVodName = itemView.findViewById(R.id.tvVodName);
            tvStreamId = itemView.findViewById(R.id.tvStreamId);
            tvCreationDate = itemView.findViewById(R.id.tvCreationDate);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvFileSize = itemView.findViewById(R.id.tvFileSize);
            tvFilePath = itemView.findViewById(R.id.tvFilePath);
            tvVodId = itemView.findViewById(R.id.tvVodId);
            tvType = itemView.findViewById(R.id.tvType);
        }

    }
}
