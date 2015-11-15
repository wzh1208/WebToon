package com.pluu.webtoon.item;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 웹툰 정보 Item Class
 * Created by nohhs on 2015-04-07.
 */
public class WebToonInfo implements Parcelable {

	protected final String webtoonId;
	protected String title;
	protected String image;
	protected WebToonType type = WebToonType.TOON;
	protected String rate, writer;
	protected String updateDate;
	protected Status status = Status.NONE;
	protected boolean adult = false;
	protected boolean loginNeed = false;
	protected boolean favorite = false;

	public WebToonInfo(String id) {
		this.webtoonId = id;
	}

	public WebToonInfo(WebToonInfo item) {
		this.webtoonId = item.webtoonId;
		this.title = item.title;
		this.image = item.image;
		this.type = item.type;
		this.rate = item.rate;
		this.writer = item.writer;
		this.updateDate = item.updateDate;
		this.status = item.status;
		this.adult = item.adult;
		this.loginNeed = item.loginNeed;
		this.favorite = item.favorite;
	}

	public String getWebtoonId() {
		return webtoonId;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public WebToonType getType() {
		return type;
	}

	public String getRate() {
		return rate;
	}

	public String getWriter() {
		return writer;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isAdult() {
		return adult;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setType(WebToonType type) {
		this.type = type;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setIsAdult(boolean isAdult) {
		this.adult = isAdult;
	}

	public void setIsFavorite(boolean isFavorite) {
		this.favorite = isFavorite;
	}

	public boolean isLoginNeed() {
		return loginNeed || adult;
	}

	public void setIsLoginNeed(boolean isLoginNeed) {
		this.loginNeed = isLoginNeed;
	}

	@Override
	public int describeContents() { return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.webtoonId);
		dest.writeString(this.title);
		dest.writeString(this.image);
		dest.writeInt(this.type == null ? -1 : this.type.ordinal());
		dest.writeString(this.rate);
		dest.writeString(this.writer);
		dest.writeString(this.updateDate);
		dest.writeInt(this.status == null ? -1 : this.status.ordinal());
		dest.writeByte(adult ? (byte) 1 : (byte) 0);
		dest.writeByte(loginNeed ? (byte) 1 : (byte) 0);
		dest.writeByte(favorite ? (byte) 1 : (byte) 0);
	}

	protected WebToonInfo(Parcel in) {
		this.webtoonId = in.readString();
		this.title = in.readString();
		this.image = in.readString();
		int tmpType = in.readInt();
		this.type = tmpType == -1 ? null : WebToonType.values()[tmpType];
		this.rate = in.readString();
		this.writer = in.readString();
		this.updateDate = in.readString();
		int tmpStatus = in.readInt();
		this.status = tmpStatus == -1 ? null : Status.values()[tmpStatus];
		this.adult = in.readByte() != 0;
		this.loginNeed = in.readByte() != 0;
		this.favorite = in.readByte() != 0;
	}

	public static final Creator<WebToonInfo> CREATOR = new Creator<WebToonInfo>() {
		public WebToonInfo createFromParcel(Parcel source) {return new WebToonInfo(source);}

		public WebToonInfo[] newArray(int size) {return new WebToonInfo[size];}
	};

	@Override
	public String toString() {
		return "WebToonInfo{" +
			"webtoonId='" + webtoonId + '\'' +
			", title='" + title + '\'' +
			", image='" + image + '\'' +
			", type=" + type +
			", rate='" + rate + '\'' +
			", writer='" + writer + '\'' +
			", updateDate='" + updateDate + '\'' +
			", status=" + status +
			", adult=" + adult +
			", favorite=" + favorite +
			'}';
	}
}