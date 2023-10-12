const express = require("express");
const app = express();
const mongoose = require("mongoose");
const cors = require("cors");
const morgan = require("morgan");
const postModel = require("./model/post.model");
const commentModel = require("./model/comment.model");
const userModel = require("./model/user.model");
const userRoute = require("./routes/user.route");
require("dotenv").config();

app.use(cors({ origin: true, credentials: true }));
app.use(express.json());

app.use(morgan("dev"));
mongoose
  .connect(
    "mongodb://solomon:santhosh@ac-qsh0xb4-shard-00-00.znvlhls.mongodb.net:27017,ac-qsh0xb4-shard-00-01.znvlhls.mongodb.net:27017,ac-qsh0xb4-shard-00-02.znvlhls.mongodb.net:27017/?ssl=true&replicaSet=atlas-i367w9-shard-0&authSource=admin&retryWrites=true&w=majority",
    {
      useNewUrlParser: true,

      useUnifiedTopology: true,
    }
  )
  .then(console.log("db connected"))
  .catch((err) => console.log("error", err));

app.get("/posts", async (req, res) => {
  const posts = await postModel
    .find()
    .populate({ path: "comments", populate: "user" })
    .populate("user");

  res.json(posts);
});
app.get("/posts/:id", async (req, res) => {
  const { id } = req.params;

  const posts = await postModel
    .find({
      user: id,
    })
    .populate({ path: "comments", populate: "user" })
    .populate("user");

  res.json(posts);
});
app.post("/post", async (req, res) => {
  const { user, title, content, created_at } = req.body;
  console.log(req.body);
  const post = await postModel.create(req.body);
  res.status(200).json(post);
});

app.get("/post/following/:id", async (req, res) => {
  const { id } = req.params;

  const following = await userModel.findById(id).select("following");
  console.log(following, "DD");

  const posts = await postModel
    .find({
      user: { $in: following.following },
    })
    .populate({ path: "comments", populate: "user" })
    .populate("user");
  console.log(posts, "DD");
  res.json(posts);
});

app.get("/comments/:id", async (req, res) => {
  const { id } = req.params;

  const comments = await commentModel
    .find({
      user: id,
    })
    .populate("user");

  res.json(comments);
});
app.post("/comment", async (req, res) => {
  try {
    const { id, user, content } = req.body;

    var comment = await commentModel.create({
      user: user,
      content: content,
    });

    const post2 = await postModel.findOneAndUpdate(
      { _id: id },
      { $push: { comments: comment } }
    );

    await comment.populate("user");
    console.log(comment);
    res.json(comment);
  } catch (err) {
    console.log(err);
  }
});

// app.put("/transactions/:id", async (req, res) => {
//   const { id } = request.params;
//   const { name, investment, returns, balance } = req.body;
//   const transactions = await transactionModel.findByIdAndUpdate(id, {
//     name,
//     investment,
//     returns,
//     balance,
//     ref_id,
//   });
//   res.status(200).json(transactions);
// });

app.use("/", userRoute);
app.listen(8080, () => {
  console.log("server started");
});
