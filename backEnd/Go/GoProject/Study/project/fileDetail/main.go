package main

import (
	"os"
	"strings"
)

func main() {

}

func getDetail(filePath string) {
	primaryFolder, err := os.Open(filePath)
	primaryFiles, err := primaryFolder.Readdir(0)
	detailFile, err := os.OpenFile(filePath+"/detailFile.csv", os.O_CREATE|os.O_RDWR|os.O_TRUNC, 0777)
	writeString, err := detailFile.WriteString(FileDetailCsvColumn)
	if writeString <= 0 {
		panic("FileWriteError")
	}
	if err != nil {
		panic(err)
	}
	for i := 0; i < len(primaryFiles); i++ {
		if primaryFiles[i].IsDir() {
			getDetail(filePath + "/" + primaryFiles[i].Name() + "/")
		} else {
			fileDetail := FileDetail{
				fileName:  primaryFiles[i].Name(),
				fileSize:  int(primaryFiles[i].Size()),
				ModTime:   primaryFiles[i].ModTime(),
				isVideo:   isVideo(primaryFiles[i].Name()),
				videoTime: getVideoTime(filePath + "/" + primaryFiles[i].Name()),
			}
			csv := fileDetail.getCsv()
			writeString, err := detailFile.WriteString(csv)
			if writeString <= 0 {
				panic("FileWriteError")
			}
			if err != nil {
				panic(err)
			}
		}
	}
}

func getVideoTime(s string) string {
	return ""
}

func isVideo(name string) bool {
	videoTypes := []string{".mp4", ".flv", ""}
	for _, videoType := range videoTypes {
		if strings.HasSuffix(name, videoType) {
			return true
		}
	}
	return false
}
