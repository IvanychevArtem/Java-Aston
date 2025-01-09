class Triangle implements Geometric {
   private int base;
   private int oneSide;
   private int twoSide;
   private int height;
   private String backgroundColor;
   private String borderColor;

    public Triangle(int base, int height, int oneSide, int twoSide, String borderColor, String backgroundColor) {
        this.borderColor = borderColor;
        this.base = base;
        this.height = height;
        this.backgroundColor = backgroundColor;
    }
    @Override
    public double getPerimeter() {
        return oneSide+twoSide+base;
    }

    @Override
    public double getSquare() {
        return (height*base)/2;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
