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

import dots.util.Driver;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;

/**@author Timothy Chandler*/
public class Game extends JPanel{
    
    private boolean draw;
    private ArrayList<Ellipse2D> dots;
    private ArrayList<Line> lines;
    private Grid grid;
    private Graphics2D canvas;
    private Point clickPoint;
    private Point dragPoint;
    
    public Game(Grid g){
        clickPoint = new Point();
        draw = false;
        grid = g;
        dots = new ArrayList<>();
        lines = new ArrayList<>();
        dotMaker();
        lineMaker();
        addListeners();
        repaint();
    }
    
    private void addListeners(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                clickPoint = e.getPoint();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                draw = false;
                Driver.dots.repaintGame();
                lineDiscovery();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                draw = true;
                dragPoint = e.getPoint();
                Driver.dots.repaintGame();
            }
        });
    }
    
    private void dotMaker(){
        ArrayList<Dot> temp = Driver.grid.getDots();
        for(Dot dot : temp) {
            dots.add(dot.getEllipse());
        }
        Driver.dots.setSize(((2 * grid.getSize()[1] + 2) * 21), ((2 * grid.getSize()[0] + 3) * 21) + 21);
    }
    
    private void lineMaker(){
        ArrayList<Line> temp = Driver.grid.getLines();
        for(Line line : temp) {
            lines.add(line);
        }
    }
    
    private boolean lineDiscovery(){
        Ellipse2D start = null;
        Ellipse2D end = null;
        for(Ellipse2D e: dots){
            if(e.contains(clickPoint)){
                start = e;
                break;
            }
        }
        for(Ellipse2D e: dots){
            if(e.contains(dragPoint)){
                end = e;
                break;
            }
        }
        
        if(start != null && end != null && !start.equals(end)){
            if(Math.abs(start.getFrame().getMinX() - end.getFrame().getMinX()) <= 42 &&
                    start.getFrame().getMinY() == end.getMinY()){
                enableLine(start, end);
                return true;
            }else if(Math.abs(start.getFrame().getMinY() - end.getFrame().getMinY()) <= 42 &&
                    start.getFrame().getMinX() == end.getMinX()){
                enableLine(start, end);
                return true;
            }
        }
        return false;
    }
    
    private void enableLine(Ellipse2D start, Ellipse2D end){
        int x = dots.indexOf(start);
        int y = dots.indexOf(end);
        if(x - y > 0){
            if(x - y != 1){
                lines.get(y).setDrawn(true);
                lines.get(y).setColor(Driver.getCurrentColor());
            }else{
                int idx = getIndex(x);
                lines.get(idx).setDrawn(true);
                lines.get(idx).setColor(Driver.getCurrentColor());
            }
        }else{
            if(x - y != -1){
                lines.get(x).setDrawn(true);
                lines.get(x).setColor(Driver.getCurrentColor());
            }else{
                int idx = getIndex(y);
                lines.get(idx).setDrawn(true);
                lines.get(idx).setColor(Driver.getCurrentColor());
            }
        }
        boolean change = true;
        for(Square s: Driver.grid.getSquares()){
            if(s.isDrawn() && s.getColor() == null){
                s.setColor(Driver.getCurrentColor());
                change = false;
            }
        }
        if(change){
            Driver.switchColor();
        }
        repaint();
    }
    
    private int getIndex(int dot){
        if(grid.getSize()[0] > grid.getSize()[1]){
            return (lines.size() / 2) + (dot - (dot / grid.getSize()[1]));
        }
        return (lines.size() / 2) + (dot - ((dot / grid.getSize()[1]) + 1));
    }
            
    @Override
    public void paintComponent(Graphics comp){
        canvas = (Graphics2D)comp;
        canvas.setColor(Color.WHITE);
        Rectangle2D.Float background = new Rectangle2D.Float(
                0f, 0f, (float)getSize().width, (float)getSize().height);
        canvas.fill(background);
        BasicStroke pen = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        canvas.setStroke(pen);
        pen = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        canvas.setColor(Color.BLACK);
        for(Square s: Driver.grid.getSquares()){
            if(s.isDrawn()){
                canvas.setColor(s.getColor());
                canvas.fill(s.getRectangle());
                
            }
        }
        for(Line l: lines) {
            if(l.isDrawn()){
                canvas.setColor(l.getColor());
                canvas.fill(l.getRectangle());
                canvas.setColor(Color.BLACK);
                canvas.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                canvas.draw(l.getRectangle());
                canvas.setStroke(pen);
            }
        }
        canvas.setColor(Color.BLACK);
        for(Ellipse2D e: dots){
            canvas.fill(e);
        }
        if(draw){
            canvas.setPaintMode();
            canvas.setColor(Color.BLACK);
            canvas.setStroke(pen);
            canvas.drawLine(clickPoint.x,clickPoint.y,dragPoint.x,dragPoint.y);
            
        }
    }
}
