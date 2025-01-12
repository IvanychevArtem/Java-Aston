class Triangle implements Geometric {
   private int base;
   private int oneSide;
   private int twoSide;
   private String backgroundColor;
   private String borderColor;

    public Triangle(int base, int oneSide, int twoSide, String borderColor, String backgroundColor) {
        this.borderColor = borderColor;
        this.base = base;
        this.backgroundColor = backgroundColor;
    }
    @Override
    public double getPerimeter() {
        return oneSide+twoSide+base;
    }

    @Override
    public double getSquare() {
        double p = getPerimeter() / 2.0;
        return Math.sqrt(p * (p - oneSide) * (p - twoSide) * (p - base));
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
