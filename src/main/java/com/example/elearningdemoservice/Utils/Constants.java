package com.example.elearningdemoservice.Utils;

public class Constants {
    public static interface TRANG_THAI{
        public static final int CHUA_THANH_LY = 0;
        public static final int DA_THANH_LY = 1;
    }

    public static interface TRANG_THAI_CHO_THUE{
        public static final int CO = 1;
        public static final int KHONG = 0;
    }

    public static interface TRANG_THAI_XE_HOAT_DONG{
        public static final String HOAT_DONG = "1";
        public static final String DUNG_HOAT_DONG = "2";
    }

    public static interface HINH_THUC_UNG_TIEN{
        public static final String TIEN_MAT = "TIENMAT";
        public static final String CHUYEN_KHOAN = "CHUYENKHOAN";
    }

    public static interface TRANG_THAI_THONG_BAO {
        public static int CHUA_DOC = 0;
        public static int DA_DOC = 1;
    }

    public static String PASS_DEFAULT = "sdt@123";

    public static String NGAY_THUE_DEFAULT = "1";
    public static String SO_KM_DEFAULT = "250";

    public static interface GIOI_TINH {
        public static String NAM = "Nam";
        public static String NU = "Nữ";
    }

    public static interface LOAI_KHACH_HANG {
        public static long VIP = 1;
        public static long TIEM_NANG = 2;
        public static long MOI = 3;
        public static long KO_CHO_THUE = 4;
    }

    public static interface LOAI_KHACH_HANG_STRING {
        public static String VIP = "Khách hàng Vip";
        public static String TIEM_NANG = "Khách hàng tiềm năng";
        public static String MOI = "Khách hàng mới";
        public static String KO_CHO_THUE = "Khách hàng không cho thuê";
    }

    public static interface TINH_TRANG_XU_LY_VI_PHAM {
        public static String DA_XU_LY_VI_PHAM = "Đã nộp xong";
    }

    public static String CHUA_XU_LY_PHAT_NGUOI = "chuaXuLyPhatNguoi";

    public static interface StatusCode {
        public static int SUCCESS = 1;
        public static int FAIL = 0;
    }
}
