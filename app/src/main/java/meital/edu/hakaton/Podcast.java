package meital.edu.hakaton;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class Podcast implements Parcelable {
    private String streamName;
    private String vodName;
    private String streamId;
    private String creationDate;
    private String duration;
    private String fileSize;
    private String filePath;
    private String vodId;
    private String type;

    //empty ctor
    public Podcast(String streamName, String vodName, String creationDate, String duration, String fileSize, String filePath, String vodId, String type) {
    }

    //ctor
    public Podcast(String streamName, String vodName, String streamId, String creationDate,
                   String duration, String fileSize, String filePath, String vodId, String type) {
        this.streamName = streamName;
        this.vodName = vodName;
        this.streamId = streamId;
        this.creationDate = creationDate;
        this.duration = duration;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.vodId = vodId;
        this.type = type;
    }

    //geters & setters

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getVodName() {
        return vodName;
    }

    public void setVodName(String vodName) {
        this.vodName = vodName;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getVodId() {
        return vodId;
    }

    public void setVodId(String vodId) {
        this.vodId = vodId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "streamName='" + streamName + '\'' +
                ", vodName='" + vodName + '\'' +
                ", streamId='" + streamId + '\'' +
                ", creationDate=" + creationDate +
                ", duration=" + duration +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                ", vodId='" + vodId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.streamName);
        dest.writeString(this.vodName);
        dest.writeString(this.streamId);
        dest.writeValue(this.creationDate);
        dest.writeValue(this.duration);
        dest.writeValue(this.fileSize);
        dest.writeString(this.filePath);
        dest.writeString(this.vodId);
        dest.writeString(this.type);
    }

    protected Podcast(Parcel in) {
        this.streamName = in.readString();
        this.vodName = in.readString();
        this.streamId = in.readString();
        this.creationDate = in.readString();
        this.duration = in.readString();
        this.fileSize = in.readString();
        this.filePath = in.readString();
        this.vodId = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<Podcast> CREATOR = new Parcelable.Creator<Podcast>() {
        @Override
        public Podcast createFromParcel(Parcel source) {
            return new Podcast(source);
        }

        @Override
        public Podcast[] newArray(int size) {
            return new Podcast[size];
        }
    };
}