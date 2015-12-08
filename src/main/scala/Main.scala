import java.awt.{Toolkit, SystemTray}
import javafx.application.{Platform, Application}
import javafx.fxml.FXMLLoader
import javafx.scene.media.{MediaPlayer, Media, MediaView}
import javafx.scene.{Node, Scene, Parent}
import javafx.stage.Stage
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.Image
;

object Main {
  def main(args: Array[String]) {
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    Platform.setImplicitExit(false)

    primaryStage.setTitle("Test")
    primaryStage.setScene(new Scene(FXMLLoader.load(getClass.getResource("/main.fxml")), 1800, 1000))
    primaryStage.show()

    createTrayIcon(primaryStage)

    //val mediaPlayer:MediaManager = new MediaManager("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv")
    val mediaPlayer:MediaManager = new MediaManager("http://podcastdown.sbs.co.kr/powerfm/2015/12/power-pc-20151207(11-00)-2.mp3?vod_id=V0000365040&podcast_id=P0000000222")

    val mediaView:MediaView = primaryStage.getScene.lookup("#mediaView").asInstanceOf[MediaView]
    mediaView.setMediaPlayer(mediaPlayer.mediaPlayer)
    mediaPlayer.play
  }

  def createTrayIcon(stage:Stage): Unit = {
    if (SystemTray.isSupported()) {
      val tray:SystemTray = SystemTray.getSystemTray()
      val image:Image = Toolkit.getDefaultToolkit().getImage(getClass.getResource("/images/icon.jpeg"))

      // create a popup menu
      val popup:PopupMenu = new PopupMenu();

      val showItem1:MenuItem = new MenuItem("검색");
      popup.add(showItem1);

      val showItem2:MenuItem = new MenuItem("알림");
      popup.add(showItem2);

      val showItem3:MenuItem = new MenuItem("종료");
      popup.add(showItem3);

      val trayIcon:TrayIcon = new TrayIcon(image, "PostItNote", popup);
      tray.add(trayIcon);
    }
  }
}