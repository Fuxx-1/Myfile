package main

import (
	"fmt"
	_ "github.com/go-sql-driver/mysql"
	"github.com/jmoiron/sqlx"
)

func main() {
	db := connectMySQL()
	defer db.Close()
	result, err := db.Exec("INSERT INTO "+
		"user(userid, username, password, avatar, create_time, update_time) "+
		"values (?, ?, ?, ?, ?, ?)",
		100, "test", "test", "test", "2022-1-1", "2022-1-1")
	if err != nil {
		panic(err)
	}
	id, _ := result.LastInsertId()
	fmt.Println(id)
	result, err = db.Exec("update user set username = 'change' where userid = 100")
	if err != nil {
		panic(err)
	}
	fmt.Println(result.LastInsertId())
	result, err = db.Exec("SELECT * FROM user")
	if err != nil {
		panic(err)
	}
}

var (
	userName = "root"
	password = "3456"
	ipAddr   = "127.0.0.1"
	port     = "3456"
	dbName   = "TEST"
	charset  = "utf8mb4"
)

func connectMySQL() *sqlx.DB {
	dbstr := fmt.Sprintf("%s:%s@tcp(%s:%s)/%s?charset=%s",
		userName, password, ipAddr, port, dbName, charset)
	DB, err := sqlx.Open("mysql", dbstr)
	if err != nil {
		panic(err)
	}
	b, err := ping(DB)
	if b {
		return DB
	} else {
		panic(err)
	}
}

func ping(DB *sqlx.DB) (bool, error) {
	err := DB.Ping()
	if err != nil {
		return false, err
	} else {
		return true, nil
	}
}
