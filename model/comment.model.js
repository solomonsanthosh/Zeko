const mongoose = require("mongoose");
const { ObjectId } = require("mongodb");
const schema = mongoose.Schema;

const commentSchema = new schema({

  
   
    user: { type : ObjectId, ref: 'Zekouser', required: true },
    content: {
      type:String,
      required:true
    }
  },
  { timestamps: { createdAt: 'created_at' 
}
}
  );

module.exports = mongoose.model("Zekocomment", commentSchema);
