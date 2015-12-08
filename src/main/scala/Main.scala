import java.awt.{Toolkit, SystemTray}
import javafx.application.{Platform, Application}
import javafx.fxml.FXMLLoader
import javafx.scene.{Scene, Parent}
import javafx.stage.Stage
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.Image;

object Main {
  def main(args: Array[String]) {
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    Platform.setImplicitExit(false)

    primaryStage.setTitle("Test")
    primaryStage.setScene(new Scene(FXMLLoader.load(getClass.getResource("/main.fxml")), 200, 200))
    primaryStage.show()

    createTrayIcon(primaryStage)
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