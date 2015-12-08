import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Scene, Parent}
import javafx.stage.Stage

object Main {
  def main(args: Array[String]) {
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("Test")
    primaryStage.setScene(new Scene(FXMLLoader.load(getClass.getResource("/main.fxml")), 200, 200))
    primaryStage.show()
  }
}