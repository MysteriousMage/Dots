/*
 * Copyright (C) 2015 Timothy Chandler
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

package dots.gui;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**@author Timothy Chandler*/
public class Grid {
    
    private ArrayList<Dot> dots;
    private ArrayList<Line> lines;
    private ArrayList<Square> squares;
    private int[] size;
    
    public Grid(int rows, int columns){
        dots = new ArrayList<>();
        lines = new ArrayList<>();
        squares = new ArrayList<>();
        size = new int[2];
        size[0] = rows;
        size[1] = columns;
        for(int i=0; i < rows; i++){
            for(int j=0; j < columns; j++){
                dots.add(new Dot(i, j, new Ellipse2D.Double((2 * j * 21) + 21, (2 * i * 21)+21, 21, 21)));
            }
        }
        ArrayList<Line> vertical = new ArrayList<>();
        for(int i=0; i < rows-1; i++){
            for(int j=0; j < columns; j++){
                vertical.add(new Line(new Rectangle2D.Double(28 + (j * 42), 28 + (i * 42) , 7, 42), Color.red, false));
            }
        }
        ArrayList<Line> horizontal = new ArrayList<>();
        for(int i=0; i < rows; i++){
            for(int j=0; j < columns-1; j++){
                horizontal.add(new Line(new Rectangle2D.Double((2 * j * 21) + 28, (2 * i * 21)+28, 42, 7), Color.red, false));
            }
        }
        for(Line line : vertical) {
            lines.add(line);
        }
        
        for(Line line : horizontal) {
            lines.add(line);
        }
        for(int i = 0; i < rows-1; i++) {
            for(int j = 0; j < columns-1; j++) {
                ArrayList<Dot> d = new ArrayList<>();
                ArrayList<Connection> c = new ArrayList<>();
                d.add(dots.get(j + (i * columns)));
                d.add(dots.get(j + (i * columns) + 1));
                d.add(dots.get(j + (i * columns) + columns));
                d.add(dots.get(j + (i * columns) + columns + 1));
                c.add(new Connection("Top", horizontal.get(j + (i * (columns - 1)))));
                c.add(new Connection("Bottom", horizontal.get(j + (i * (columns -1 )) + (columns - 1))));
                c.add(new Connection("Left", vertical.get(j + (i * columns))));
                c.add(new Connection("right", vertical.get(j + (i * columns) + 1)));
                squares.add(new Square(c, d, new Rectangle2D.Double(35 + (j * 42), 35 + (i * 42), 35, 35)));
            }
        }
    }
    
    public ArrayList getDots(){
        return dots;
    }
    
    public int[] getSize(){
        return size;
    }

    /**
     * @param dots the dots to set
     */
    public void setDots(ArrayList<Dot> dots) {
        this.dots = dots;
    }

    /**
     * @return the lines
     */
    public ArrayList<Line> getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    /**
     * @return the squares
     */
    public ArrayList<Square> getSquares() {
        return squares;
    }

    /**
     * @param squares the squares to set
     */
    public void setSquares(ArrayList<Square> squares) {
        this.squares = squares;
    }
   
}
