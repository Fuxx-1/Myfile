package main

import (
	"strconv"
	"strings"
)

type VList struct {
	title   string
	play    int
	link    string
	length  string
	created string
	author  string
}

func (vList VList) getCsv() string {
	vList.title = strings.ReplaceAll(vList.title, "\"", "'")
	return "\"" + vList.title + "\"," +
		strconv.Itoa(vList.play) + "," +
		vList.link + "," +
		"\"" + vList.length + "\"," +
		vList.created + "," +
		vList.author + "\n"
}
