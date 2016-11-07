package com.fogodev.firebird;

/**
 * Criado por ericson em 19/10/16.
 *
 * https://github.com/fogodev
 */
public class Ground
{
    private double posX;

    public Ground(double posX)
    {
        this.posX = posX;
    }

    public void draw(Tela canvas, String spriteFileName)
    {
        canvas.imagem(spriteFileName, 292, 0, 306, 111, 0, posX, 421);
    }

    public void move()
    {
        this.posX--;
        if(this.posX + 333 < 0) this.posX = 584;
    }
}
