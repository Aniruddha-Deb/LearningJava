package com.sensei.rover01;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class TerrainPlotter extends AbstractAnalysis {

	private Grid grid = null ;
	
	public TerrainPlotter( Grid grid ) {
		this.grid = grid ;
	}
	
    public void showPlot() throws Exception {
    	AnalysisLauncher.open( this ) ;
    }

    public void init() {
        // Define a function to plot
        Mapper mapper = new Mapper() {
            @Override
            public double f( double x, double y ) {
            	int xCoord = (int)x ;
            	int yCoord = (int)y ;
            	int depth  = grid.getCell( xCoord, yCoord ).getDepth() ;
            	return depth ;
            }
        };

        // Define range and precision for the function to plot
        Range xRange = new Range( 0, grid.getNumCols()-1 ) ;
        int xSteps = grid.getNumCols() ;
        
        Range yRange = new Range( 0, grid.getNumRows()-1 ) ;
        int ySteps = grid.getNumRows() ;

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid( xRange, xSteps, yRange, ySteps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(true);

        // Create a chart
        chart = AWTChartComponentFactory.chart(Quality.Advanced, getCanvasType());
        chart.getScene().getGraph().add(surface);
    }
}