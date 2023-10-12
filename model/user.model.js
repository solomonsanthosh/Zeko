const mongoose = require("mongoose");
const { ObjectId } = require("mongodb");
const schema = mongoose.Schema;

const userSchema = new schema({

  
   
    name: {
        type: String, required: true, lowercase: true
    },
    phone: {
      type:Number,required:true
    },
    email: {
      type:String,
      required:true, 
      lowercase: true
    },
    following: [{ type : ObjectId, ref: 'Zekouser' }],
    followers: [{ type : ObjectId, ref: 'Zekouser' }]
  }


  );

module.exports = mongoose.model("Zekouser", userSchema);
