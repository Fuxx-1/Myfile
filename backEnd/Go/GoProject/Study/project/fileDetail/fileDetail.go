package main

import (
	"strconv"
	"time"
)

type FileDetail struct {
	fileName  string    // 文件名
	fileSize  int       // 文件大小
	ModTime   time.Time // 文件修改时间
	isVideo   bool      // 文件是否视频
	videoTime string    // 视频时长
}

const FileDetailCsvColumn = "文件名,文件大小,修改时间,是否视频,视频时长\n"

func (fileDetail FileDetail) getCsv() string {
	if fileDetail.isVideo {
		return fileDetail.fileName + "," +
			strconv.Itoa(fileDetail.fileSize) + "," +
			fileDetail.ModTime.Format("2006-01-02_15:04:05") + "," +
			"T" + "," +
			fileDetail.videoTime +
			"\n"
	} else {
		return fileDetail.fileName + "," +
			strconv.Itoa(fileDetail.fileSize) + "," +
			fileDetail.ModTime.Format("2006-01-02_15:04:05") + "," +
			"F" + "," +
			"null" +
			"\n"
	}
}
