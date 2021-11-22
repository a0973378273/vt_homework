package priv.jb.homework.data

data class Videos(
    val status: String,
    val videos: List<Video>
)

data class Video(
    val img: String,
    val title: String
)