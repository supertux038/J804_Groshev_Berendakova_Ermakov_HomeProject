# 2D Engine
A simple library to draw flat gamefield. Made as a project for studying.
## Getting started
### Installation
Just clone the repo or download a zip and compile it. Nothing special.
### First tests
Run this and you should see an emty gamefield appear.
```
Gamefield game = new Gamefield(10,10);
GameWindow gameWindow = new GameWindow("GameWindow", 800,600, 30, game);
```
Also try this if you need more abstraction. In this example we save the game frame to png file.
```
BufferedImageGameDrawer bufferedImageGameDrawer = new BufferedImageGameDrawer(1920,1080,game);
BufferedImage gameFrameToSave = bufferedImageGameDrawer.drawGamefield();
try {
    ImageIO.write(gameFrameToSave, "png", new File("frame.png"));
} catch (IOException e) {
    e.printStackTrace();
}
```
GameWindow class has many parameters to change. Try them. Probably they will be added soon to BufferedImageGameDrawer.
```
window.setCoordinatesEnabled(false);
window.setGridColor(Color.blue);
window.setGridEnabled(false);
window.setGridThickness(4);
window.setTextColor(Color.LIGHT_GRAY);
```
To change situation on gamefield call methods of cells inside gamefield array in gamefield class.
```
gamefield.gameField[0][0].setText("Я самая первая клетка");
gamefield.gameField[1][1].setColor(Color.red);
gamefield.gameField[1][1].setText("А я красная");
gamefield.gameField[2][3].setText("Дискотека");
Timer timer = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          gamefield.gameField[2][3].setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
      }
});
timer.start();
```
## Built with
We use Intelij Idea to do everything. We hope our project would work in other environments.
## Contributing
Halp us
## Authors
*Vitaly Groshev aka Hyperbot - main developer*
*Alexander Ermakov aka supertux038 - developer*
*Tanya Berendakova - git expert, professional advisor*
