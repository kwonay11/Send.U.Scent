//express 모듈 불러오기
const express = require("express");

//express 사용
const app = express();


var mysql = require('mysql');
var connection = mysql.createConnection({
    host: 'J5C204.p.ssafy.io', 
    port: '3306', 
    user: 'scent', 
    password: 'scent', 
    database: 'recommand'
});

//Express 4.16.0버전 부터 body-parser의 일부 기능이 익스프레스에 내장 body-parser 연결 
app.use(express.json());
app.use(express.urlencoded({ extended: true}));

app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers");
    res.header("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
    next();
});


connection.connect();

// configuration ===============================================================

app.set('port', process.env.PORT || 8888);
app.get('/', function(req, res){
  res.send('Hello World! Bro!');
});



// app.get("/api/users/user", (req, res) => {
//   connection.query('SELECT * FROM user', function(err, rows) {
//     if(err) throw err;
    
//     let user_id = req.query.user_id
//     console.log(user_id)
//     console.log(rows)
//     const user = rows.filter(data => data.user_id == user_id);
//     // console.log('login is : ', user);
//     res.send(user);
//   });
// })


app.post("/suscent/api/login/", (req, res) => {
  connection.query('SELECT * FROM user WHERE user_id = ? AND password = ?', [req.body.user_id, req.body.password], function(error, results, fields) {
    if (results.length === 0) {
      res.send({
        "code" : 500
      })
    } else {
      
      console.log('The solution is: ', results);
      
      res.send({
        "code": 200,
        "user_id": results[0].user_id,
        "success": "user login sucessfully"
      });
    }
  })
  
})
/**
 *  POST 데이터를 생성할 때 사용된다.
 *  req.body에 데이터를 담아서 보통 보낸다.
 */
app.post("/suscent/api/users/signup", (req, res) => {    
  connection.query(`INSERT INTO user(user_id, nickname, password) VALUES("${req.body.user_id}", "${req.body.nickname}", "${req.body.password}")`, function (error, results, fields) {
    if (error) {
      console.log("error ocurred", error);
      res.send({
        "code" : 400,
        "failed": "error ocurred"
      })
    } else {
      console.log(req.body.user_id)
      connection.query('SELECT * FROM user WHERE user_id = ?', [req.body.user_id], function(error, results, fields) {
        
        // console.log('The solution is: ', results);
        
        res.send({
          "code": 200,
          "user_id": results[0].user_id,
          "password": results[0].password,
          "nickname": results[0].nickname,
          "success": "user registered sucessfully"
        });
      })
    }
  })    
})



// notice 파트

app.get("/suscent/api/notices", (req, res) => {
    connection.query('SELECT * FROM notice', function(err, rows) {
        if(err) throw err;

        // console.log('The solution is: ', rows);
        res.send(rows);
    });
})

app.get("/suscent/api/notice/:id", (req, res) => {
    console.log('notice')
    let notice_id = req.params.id

      
    connection.query('SELECT * FROM notice WHERE id = ?', [notice_id], function(err, results, fields) {
      if(err) throw err;

      // console.log('The solution is: ', results);
      
      res.send({
          "code": 200,
          "id": results[0].id,
          "title": results[0].title,
          "contents": results[0].contents,
          "user": results[0].user,
          "success": "get notice sucessfully"
      });
    })
    
})
app.put("/suscent/api/notice/modify/", (req, res) => {
  console.log('처음수정')
  connection.query(`UPDATE notice SET user=? AND title=? AND contents=? where id=?` ,[req.body.user, req.body.title, req.body.contents, req.body.id], function (error, results, fields) {
    if (error) {
      console.log("error ocurred", error);
      res.send({
        "code" : 400,
        "failed": "error ocurred"
      })
    } else {
      console.log(req.body.title)
      res.send({
        "code" : 200,
        "failed": "success"
      })
      
      }
  })    
})



app.post("/suscent/api/notices/write", (req, res) => {    
    connection.query(`INSERT INTO notice(title, contents) VALUES("${req.body.title}", "${req.body.contents}")`, function (error, results, fields) {
        if (error) {
            res.send({
                "code" : 400,
                "failed": "error ocurred"
            })
        } else {
            res.send({
              "code" : 200,
              "success": "성공띠"
            })
          }
        
    })    
})

app.delete("/suscent/api/notices/delete/:id", (req, res) => {

  console.log('notice')
  // let notice_id = req.params.id
  // console.log(notice_id)
  console.log(req.params.id)
  connection.query('DELETE FROM notice WHERE id = ?', [req.params.id], function (error, results, fields) {
    if (error) {
        res.send({
            "code" : 400,
            "failed": "error ocurred"
        })
    } else {
        res.send({
          "code" : 200,
          "success": "제거 성공띠"
        })
      }
    
})    
})

// http listen port 생성 서버 실행
app.listen(8888, () => console.log("Send.U.Scent :)"));