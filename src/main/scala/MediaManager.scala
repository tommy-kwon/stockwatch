import javafx.scene.media.{MediaPlayer, Media}

/**
  * Created by tommy on 2015. 12. 8..
  */
class MediaManager(url:String) {
  private val _mediaPlayer:MediaPlayer = new MediaPlayer(new Media(url))

  def mediaPlayer = _mediaPlayer

  def prepare(): Unit = {
    _mediaPlayer.setAutoPlay(true)
  }

  def play: Unit = {
    _mediaPlayer.play()
  }

  def pause: Unit = {
    _mediaPlayer.pause()
  }

  def resume: Unit = {
    _mediaPlayer.play()
  }
}
