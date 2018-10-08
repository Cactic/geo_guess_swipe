package com.example.prive.geo_guess_swipe;

public class Photos {
        private int imageName;

        public Photos(int imageName){
            this.imageName = imageName;
    }
        public int getImageName() {
            return imageName;
        }

        public void setImageName(int imageName) {
            this.imageName = imageName;
        }

        public static final int[] cityImageArray = {
                R.drawable.img1_yes_denmark,
                R.drawable.img2_no_canada,
                R.drawable.img3_no_bangladesh,
                R.drawable.img4_yes_kazachstan,
                R.drawable.img5_no_colombia,
                R.drawable.img6_yes_poland,
                R.drawable.img7_yes_malta,
                R.drawable.img8_no_thailand
        };
}
