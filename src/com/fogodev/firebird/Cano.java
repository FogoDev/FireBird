package com.fogodev.firebird;

/**
 * Criado por ericson em 20/10/16.
 *
 * https://github.com/fogodev
 */
public class Cano
{
    private double posX;
    private int width = 52;
    private int topPipeHeight;
    private int bottomPipeHeight ;
    private int gap = 100;

    private Hitbox topPipeHitbox = new Hitbox(
            this.posX,
            0,
            this.posX + this.width,
            this.topPipeHeight
    );

    private Hitbox bottomPipeHitbox = new Hitbox(
            this.posX,
            this.topPipeHeight + this.gap,
            this.posX + this.width,
            this.topPipeHeight + this.gap + this.bottomPipeHeight
    );

    public Cano(double posX, int topPipeHeight, Jogo game)
    {
        this.posX = posX;
        this.topPipeHeight = topPipeHeight;
        this.bottomPipeHeight =   game.getAltura() - (this.gap + topPipeHeight);
    }

    public void move()
    {
        this.posX--;
        this.topPipeHitbox.mover(this.posX + 2, 0, this.posX + this.width, this.topPipeHeight);
        this.bottomPipeHitbox.mover(this.posX + 4, this.topPipeHeight + this.gap, this.posX + this.width, this.topPipeHeight + this.gap + this.bottomPipeHeight);
    }

    public void draw(Tela canvas, String spriteFileName)
    {
        canvas.imagem(spriteFileName, 604, 270 - this.topPipeHeight, this.width, this.topPipeHeight, 0, this.posX, 0);
        canvas.imagem(spriteFileName, 660, 0, this.width, this.bottomPipeHeight, 0, this.posX, this.topPipeHeight + this.gap);
    }

    public boolean checkCollision(Hitbox hitbox)
    {
        return this.topPipeHitbox.intersecao(hitbox) > 0  || this.bottomPipeHitbox.intersecao(hitbox) > 0;
    }

    public double getPosX()
    {
        return this.posX;
    }

    public int getWidth()
    {
        return this.width;
    }
}
