public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double x) {
        this.from = x;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double y) {
        this.to = y;
    }

    public double getLength(double from, double to) {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public String getIntersection(double from, double to) {
        if (from < this.to && to > this.from) {
            return Math.max(from, this.from) + " ; " + Math.min(to, this.to);
        }

        return null;
    }

    public double[][] getIntervalsUnification(double from, double to) {
        if (from <= this.to && to >= this.from) {
            return new double[][]{{Math.min(from, this.from), Math.max(this.to, to)}};
        }

        return new double[][]{{from, to}, {this.from, this.to}};
    }

    public double[][] getIntervalsDifference(double from, double to) {
        if (getIntersection(from, to) == null || from >= this.from && to <= this.to) {
            return null;
        }

        if (from <= this.from) {
            if (to > this.to) {
                return new double[][]{{from, this.from}, {this.to, to}};
            }

            return new double[][]{{from, this.from}};
        }

        return new double[][]{{this.to, to}};
    }
}