var express = require("express");
var mysql = require("mysql");
var bodyParser = require("body-parser");
var path = require("path");
var static = require("serve-static");
var jsonexport = require("jsonexport");
var fs = require("fs");

var app = express();
var port = process.env.PORT || 3000;
var router = express.Router();

// Configure app to use bodyParser()
app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(bodyParser.json());

app.use('/', static(path.join(__dirname, '/')));

var pool = mysql.createPool({
    connectionLimit: 100,
    host: '******.amazonaws.com',
    user: '******',
    password: '******',
    database: '******',
    debug: false
});

// Add result
var addResult = function (school, examiner, caseNumber, typeChoose, sex, timeStamp, oneA, oneB, oneC, two, twoOne, twoTwo, twoThree, three, four, fourOne, fourTwo, fiveA, fiveB, sixA, sixB, seven, sevenTwo, eight, nine, ten, eleven, nihss, nknihss, total, startTime, endTime, callback) {

    console.log('addResult called');

    pool.getConnection(function (err, conn) {
        if (err) {
            if (conn) {
                conn.release();
            }
            callback(err, null);
            return;
        }
        console.log('DB insert connected');

        var data = { School: school, Examiner: examiner, CaseNumber: caseNumber, TypeChoose: typeChoose, Sex: sex, TimeStamp: timeStamp, OneA: oneA, OneB: oneB, OneC: oneC, Two: two, TwoOne: twoOne, TwoTwo: twoTwo, TwoThree: twoThree, Three: three, Four: four, FourOne: fourOne, FourTwo: fourTwo, FiveA: fiveA, FiveB: fiveB, SixA: sixA, SixB: sixB, Seven: seven, SevenTwo: sevenTwo, Eight: eight, Nine: nine, Ten: ten, Eleven: eleven, Nihss: nihss, Nknihss: nknihss, Total: total, StartTime: startTime, EndTime: endTime };

        var exec = conn.query('insert into Information set ?', data, function (err, result) {
            conn.release();
            console.log('SQL execute: ' + exec.sql);

            if (err) {
                console.log('SQL error');
                callback(err, null);
                return;
            }
            callback(null, result);
        });
    });
}


// Send to db
router.route('/process/send').post(function (req, res) {
    console.log('/process/send used.');
    console.log(req.body);

    var School = req.body.school || req.query.school;
    var Examiner = req.body.examiner || req.query.examiner;
    var CaseNumber = req.body.caseNumber || req.query.caseNumber;
    var TypeChoose = req.body.typeChoose || req.query.typeChoose;
    var Sex = req.body.sex || req.query.sex;
    var TimeStamp = req.body.timeStamp || req.query.timeStamp;
    var OneA = req.body.oneA || req.query.oneA;
    var OneB = req.body.oneB || req.query.oneB;
    var OneC = req.body.oneC || req.query.oneC;
    var Two = req.body.two || req.query.two;
    var TwoOne = req.body.twoOne || req.query.twoOne;
    var TwoTwo = req.body.twoTwo || req.query.twoTwo;
    var TwoThree = req.body.twoThree || req.query.twoThree;
    var Three = req.body.three || req.query.three;
    var Four = req.body.four || req.query.four;
    var FourOne = req.body.fourOne || req.query.fourOne;
    var FourTwo = req.body.fourTwo || req.query.fourTwo;
    var FiveA = req.body.fiveA || req.query.fiveA;
    var FiveB = req.body.fiveB || req.query.fiveB;
    var SixA = req.body.sixA || req.query.sixA;
    var SixB = req.body.sixB || req.query.sixB;
    var Seven = req.body.seven || req.query.seven;
    var SevenTwo = req.body.sevenTwo || req.query.sevenTwo;
    var Eight = req.body.eight || req.query.eight;
    var Nine = req.body.nine || req.query.nine;
    var Ten = req.body.ten || req.query.ten;
    var Eleven = req.body.eleven || req.query.eleven;
    var Nihss = req.body.nihss || req.query.nihss;
    var Nknihss = req.body.nknihss || req.query.nknihss;
    var Total = req.body.total || req.query.total;
    var StartTime = req.body.startTime || req.query.startTime;
    var EndTime = req.body.endTime || req.query.endTime;

    if (pool) {
        addResult(School, Examiner, CaseNumber, TypeChoose, Sex, TimeStamp, OneA, OneB, OneC, Two, TwoOne, TwoTwo, TwoThree, Three, Four, FourOne, FourTwo, FiveA, FiveB, SixA, SixB, Seven, SevenTwo, Eight, Nine, Ten, Eleven, Nihss, Nknihss, Total, StartTime, EndTime, function (err, addedResult) {
            if (err) {
                console.error('result add error: ' + err.stack);
            }
            if (addedResult) {
                console.log('data saved');
                res.json({
                    result: true
                });
            }
            else {
                console.log('data save fail')
            }
        });
    } else {
        console.log("db connect fail");
    }

});

// Get data from~to 
var dbUse = function (timeStampFrom, timeStampTo, callback) {
    console.log('dbUse called');

    pool.getConnection(function (err, conn) {
        if (err) {
            if (conn) {
                conn.release();
            }
            callback(err, null);
            return;
        }
        console.log('DB select connected');

        var tablename = 'Information';
        var ntimeStampTo = new Date(timeStampTo);
        ntimeStampTo.setDate(ntimeStampTo.getDate()+1);

        var exec = conn.query("select * from ?? where timeStamp >= ? and timeStamp <= ?", [tablename, timeStampFrom, ntimeStampTo.toISOString()], function (err, rows) {
            conn.release();
            console.log('SQL execute: ' + exec.sql);

            console.log(rows);

            var options = { encoding: 'utf8' };

            jsonexport(rows, function (err, csv) {
                if (err) return console.log(err);
                fs.writeFile('./data.csv', csv, options, function (err) {
                    if (err) {
                        console.log('Error: ' + err);
                    }
                    console.log('data excel made');
                });
            });
            if (err) {
                console.log('SQL error');
                callback(err, null);
                return;
            }
            callback(null, rows);
        });
    });
}

router.route('/admin').post(function (req, res) {
    console.log("admin connect")
    var timeStampFrom = req.body.timestampfrom || req.query.timestampfrom;
    var timeStampTo = req.body.timestampto || req.query.timestampto;

    if (pool) {
        dbUse(timeStampFrom, timeStampTo, function (err, addedExcel) {
            if (err) {
                console.error('excel add error: ' + err.stack);
            }
            if (addedExcel) {
                console.log('data loaded');
                res.redirect('http://******/data.csv');
            }
            else {
                console.log('data load fail')
            }
        });
    }
});

app.use('/', router);

// Start server
app.listen(port, () => { console.log(`server running : ${port}`) });