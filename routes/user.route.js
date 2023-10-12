const express = require("express");

const {
  createUser,
  getSingleUser,
  addFollower,
  getFollowers,
  getUserByPhone
  
} = require("../controller/user.controller");
const Routes = express.Router();


Routes.post("/user", createUser);
Routes.get("/user/:email", getSingleUser);
Routes.get("/userphone/:phone", getUserByPhone);
Routes.get("/user/:id/:type", getFollowers);
Routes.put("/connection", addFollower);
module.exports = Routes;
