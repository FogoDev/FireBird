package com.fogodev.firebird;

/**
 * Criado por ericson em 19/10/16.
 *
 * https://github.com/fogodev
 */
public class Scenario
{
    private String spritesFileName;
    private Ground ground[] = new Ground[3];

    public Scenario(String spritesFileName)
    {
        this.spritesFileName = spritesFileName;
        this.ground[0] = new Ground(0);
        this.ground[1] = new Ground(306);
        this.ground[2] = new Ground(612);
    }

    public void drawBackground(Tela canvas)
    {
        canvas.imagem(this.spritesFileName, 0, 0, 286, 512, 0, 0, 0);
        canvas.imagem(this.spritesFileName, 0, 0, 286, 512, 0, 286, 0);
        canvas.imagem(this.spritesFileName, 0, 0, 286, 512, 0, 572, 0);
    }

    public void drawGround(Tela canvas)
    {
        for(Ground ground : this.ground){
            ground.draw(canvas, this.spritesFileName);
        }
    }

    public void moveGround()
    {
        for(Ground ground : this.ground){
            ground.move();
        }
    }
}
