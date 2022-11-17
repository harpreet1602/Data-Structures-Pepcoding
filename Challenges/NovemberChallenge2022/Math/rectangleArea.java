package Math;

public class rectangleArea {
    
    // 223. Rectangle Area
// tc O(1) sc O(1)
// Actually with these two end points, the length and height of the rectangle can be easily calculated
// by subtracting the coordinates with each other and then multiplying the length and height we get the area
// Now the main thing comes here is to find the coordinates of common area if exists and negative height or length will come incase common area doesn't exist
// So add two rectangle's area subtract common area between the two if exists 
public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int areaR1, areaR2,cx1,cy1,cx2,cy2,cArea,cl,ch;
    areaR1 = (ax2-ax1)*(ay2-ay1); 
    areaR2 = (bx2-bx1)*(by2-by1);

    cx1 = Math.max(ax1,bx1);
    cy1 = Math.max(ay1,by1); 
    cx2 = Math.min(ax2,bx2);
    cy2 = Math.min(ay2,by2);

    cl = (cx2-cx1);
    ch = (cy2-cy1);
    cArea = 0;
    if(cl>0 && ch>0){
        cArea = cl*ch;
    }
    return areaR1 + areaR2 - cArea;
}
}
