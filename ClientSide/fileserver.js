// Modules
var http  = require("http");
var fs    = require("fs");
var path  = require("path");

// Extensions to serve
var extensions = {
    ".html" : "text/html",
    ".css" : "text/css",
    ".js" : "application/javascript",
    ".png" : "image/png",
    ".gif" : "image/gif",
    ".jpg" : "image/jpeg"
}

// Create server and listen for an http-request
http.createServer(requestHandler).listen(3001);


function requestHandler(req, res) {

    var fileName = path.basename(req.url) || "index.html";
    var ext = path.extname(fileName);

    var localFolder = __dirname;
    if (ext === ".html") {
         localFolder += "/html/";
    } else if (ext === ".css") {
        localFolder += "/css/";
    } else if (ext === ".js") {
        localFolder += "/js/";
    } else if (ext === ".jpg") {
        localFolder += "/img/";
    }

    var page404 = localFolder + "/html/notfound.html";

    if (!extensions[ext]) {
        res.writeHead(404, {"Content-Type": "text/html"});
        res.end("&lt;html&gt;&lt;head&gt;&lt;/head&gt;&lt;body&gt;The requested file type is not supported&lt;/body&gt;&lt;/html&gt;");
    };

    getFile((localFolder + fileName), res, page404, extensions[ext]);
}


function getFile(filePath, res, page404, mimeType) {

    fs.exists(filePath, function(exists){

        if (exists){

            fs.readFile(filePath, function(err, contents){

                if(!err) {

                    res.writeHead(200, {
                        "Content-type": mimeType,
                        "Content-lenght": contents.length
                    });
                    res.end(contents);

                } else {
                    console.dir(err);
                }

            });

        } else {

            fs.readFile(page404, function(err, content){

                if(!err) {

                    res.writeHead(404, {"Content-Type": "text/html"});
                    res.end(content);

                } else {
                    console.dir(err);
                }

            });

        }

    });

}