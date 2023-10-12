const { default: mongoose } = require("mongoose");

const User = require("../model/user.model");

exports.createUser = async (req, res) => {
  try {
    const { email, name,phone } = req.body;
    console.log(req.body);
    const existingUser = await User.findOne({ email: email });
    if (existingUser) {
      return res.json({
        error: "already_exists",
      });
    }
    const user = await User.create({ email: email, name: name ,phone:phone});
    res.json(user);
  } catch (err) {
    console.log(err);
  }
};

exports.addFollower = async (req, res) => {
  try {
    const { userid, followerid,type } = req.body;

    if(type == "push"){
      await User.findOneAndUpdate(
        { _id: userid },
        { $push: { following: followerid } }
      );
      await User.findOneAndUpdate(
        { _id: followerid },
        { $push: { followers: userid } }
      );
    } else {
      await User.findOneAndUpdate(
        { _id: userid },
        { $pull: { following: followerid } }
      );
      await User.findOneAndUpdate(
        { _id: followerid },
        { $pull: { followers: userid } }
      );
    }
    

    res.json({data:null,type:"success"});
  } catch (err) {
    res.json({data:null,type:"error"});
  }
};

exports.getSingleUser = async (req, res) => {
  try {
    const { email } = req.params;

    const user = await User.findOne({ email: email });

    res.json(user);
  } catch (err) {
    console.log(err);
  }
};

exports.getUserByPhone = async (req, res) => {
  try {
    const { phone } = req.params;


    const user = await User.findOne({ phone: parseInt(phone) });

    if(user){
      res.json({data:user, type:"found"})
    }  else {
      res.json({data:null, type:"notfound"})

    }

    
  } catch (err) {
    console.log(err);
  }
};

exports.getFollowers = async (req, res) => {
  try {
    const { id, type } = req.params;

    const user = await User.findById(id).populate(type).select(type)



    
    res.json(user[type]);
  } catch (err) {
    console.log(err);
  }
};
