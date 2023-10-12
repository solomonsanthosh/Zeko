const mongoose = require("mongoose");
const { ObjectId } = require("mongodb");
const schema = mongoose.Schema;

const postSchema = new schema(
  {
    user: { type : ObjectId, ref: 'Zekouser', required: true },
    title: { type: String, required: true },
    content: { type: String, required: true },
    created_at:{ type: Number, required: true },
    comments: [{ type : ObjectId, ref: 'Zekocomment' }],
    anonymous: {
      type: Boolean,default:false
    }
  }
);

module.exports = mongoose.model("ZekoPost", postSchema);
