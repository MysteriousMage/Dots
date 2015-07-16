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
import java.awt.geom.Rectangle2D;

/**@author Timothy Chandler*/
public class Line {
    
    private Rectangle2D rectangle;
    private Color color;
    private boolean drawn;
    
    public Line(Rectangle2D r, Color c, boolean visible){
        rectangle = r;
        color = c;
        drawn = visible;
    }

    /**
     * @return the rectangle
     */
    public Rectangle2D getRectangle() {
        return rectangle;
    }

    /**
     * @param rectangle the rectangle to set
     */
    public void setRectangle(Rectangle2D rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the drawn
     */
    public boolean isDrawn() {
        return drawn;
    }

    /**
     * @param drawn the drawn to set
     */
    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }
    
    
}
