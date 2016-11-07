package com.fogodev.firebird;

/**
 * Criado por ericson em 20/10/16.
 *
 * https://github.com/fogodev
 */
public class Numbers
{
    static public void draw(Tela canvas, String spriteFileName, double posX, int number)
    {
        switch (number % 10){
            case 0:
                canvas.imagem(spriteFileName, 576, 200, 14, 20, 0, posX, 50);
                break;

            case 1:
                canvas.imagem(spriteFileName, 582, 236, 10, 20, 0, posX, 50);
                break;

            case 2:
                canvas.imagem(spriteFileName, 578, 268, 14, 20, 0, posX, 50);
                break;

            case 3:
                canvas.imagem(spriteFileName, 578, 300, 14, 20, 0, posX, 50);
                break;

            case 4:
                canvas.imagem(spriteFileName, 574, 346, 14, 20, 0, posX, 50);
                break;

            case 5:
                canvas.imagem(spriteFileName, 574, 370, 14, 20, 0, posX, 50);
                break;

            case 6:
                canvas.imagem(spriteFileName, 330, 490, 14, 20, 0, posX, 50);
                break;

            case 7:
                canvas.imagem(spriteFileName, 350, 490, 14, 20, 0, posX, 50);
                break;

            case 8:
                canvas.imagem(spriteFileName, 370, 490, 14, 20, 0, posX, 50);
                break;

            case 9:
                canvas.imagem(spriteFileName, 390, 490, 14, 20, 0, posX, 50);
                break;
        }
    }
}
