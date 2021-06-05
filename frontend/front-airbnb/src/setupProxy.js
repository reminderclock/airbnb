const { createProxyMiddleware } = require('http-proxy-middleware');
const cors = require("cors");

// src/setupProxy.js
module.exports = function (app) {
    app.use(
      cors(
        "/api",
        createProxyMiddleware({
          target: 'http://13.209.36.131:8080',
          changeOrigin: true,
        })
      )
    );
  };