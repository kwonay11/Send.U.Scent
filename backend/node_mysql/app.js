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
    res.header("Access-Control-Allow-Headers", "*");
    next();
});

var users = [
 { id: 1, name: "유저1" },
 { id: 2, name: "유저2" },
 { id: 3, name: "유저3" }
];
connection.connect();
connection.query('SELECT * from user', function(err, rows, fields) {
  if (!err)
    console.log('The solution is: ', rows);
  else
    console.log('Error while performing Query.', err);
});

// configuration ===============================================================

app.set('port', process.env.PORT || 8888);
app.get('/', function(req, res){
  res.send('Hello World! Bro!');
});


/**
 * @path {GET} http://localhost:8888/api/users
 * @description 요청 데이터 값이 없고 반환 값이 있는 GET Method
 */
// app.get("/api/users", (req, res) => {
//     connection.query('SELECT * FROM user', function(err, rows) {
//         if(err) throw err;

//         console.log('The solution is: ', rows);
//         res.send(rows);
//     });
// })
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "*");
  next();
});
app.get("/suscent/api/notices", (req, res) => {
    connection.query('SELECT * FROM notice', function(err, rows) {
        if(err) throw err;

        console.log('The solution is: ', rows);
        res.send(rows);
    });
})

app.get("/api/users/user", (req, res) => {
    connection.query('SELECT * FROM user', function(err, rows) {
        if(err) throw err;

        let user_id = req.query.user_id
        console.log(user_id)
        console.log(rows)
        const user = rows.filter(data => data.user_id == user_id);
        // console.log('login is : ', user);
        res.send(user);
    });
})


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
app.get("/suscent/api/notice/:id", (req, res) => {
    console.log('notice')
    // console.log(req.params)
    // console.log(req.params.id)
    let notice_id = req.params.id
    console.log(notice_id)
    connection.query('SELECT * FROM notice', function(err, rows) {
        if(err) throw err;
        console.log('res')
        console.log(rows)
    
        connection.query('SELECT * FROM notice WHERE id = ?', [notice_id], function(error, results, fields) {

            console.log('The solution is: ', results);
            
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
})
    

        // console.log(req)
        // // console.log(req.)
        // console.log(req.body)
        // console.log(req.body.user_id)
        // var user_id = req.body.user_id
        // let a = user_id
        // console.log(user_id)
        
        // var password = req.body.password;
        // connection.query('SELECT * FROM user WHERE user_id="qq"',
        // function( error, results) {
        //     if (error) {
        //         // console.log("error ocurred", error);
        //         res.send({
        //             "code": 400,
        //             "failed": "error ocurred"
        //         })
        //     } else {
        //         console.log('The solution is: ', results);
        //         if(results.length > 0) {
        //             if(results[0].password == password) {
        //                 res.send({
        //                     "code": 200,
        //                     "user_id": user_id,
        //                     "success": "login sucessfull"
        //                 });
        //             } else {
        //                 res.send({
        //                     "code": 204,
        //                     "user_id": user_id,
        //                     "success": "아이디나 비번이 틀리다"
        //                 });
        //             }
        //         } else {
        //             res.send({
        //                 "code":204,
        //                 "user_id": a,
        //                 "success": "아이디가 없다"
        //             });
        //         }
        //     }    
        // }) 
    



/**
 * @path {POST} http://localhost:3000/api/users/add
 * @description POST Method
 * 
 *  POST 데이터를 생성할 때 사용된다.
 *  req.body에 데이터를 담아서 보통 보낸다.
 */
app.post("/suscent/api/users/signup", (req, res) => {
    console.log('=======================================')
    console.log(req)
    console.log('========================================')

    console.log(req.body)
    // 구조분해를 통해 id 와 name을 추출
    var person = {
        "user_id": req.body.user_id,
        "nickname": req.body.nickname,
        "password": req.body.password
    }
    console.log('person')
    console.log(person)
    
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

                console.log('The solution is: ', results);
                
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
app.post("/suscent/api/notices/create", (req, res) => {
    console.log('=======================================')
    console.log(req)
    console.log('========================================')

    console.log(req.body)
    // 구조분해를 통해 id 와 name을 추출
    var person = {
        "user_id": req.body.user_id,
        "nickname": req.body.nickname,
        "password": req.body.password
    }
    console.log('person')
    console.log(person)
    
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

                console.log('The solution is: ', results);
                
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







// http listen port 생성 서버 실행
app.listen(8888, () => console.log("개발이 취미인 남자 :)"));