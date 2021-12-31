import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HangHoaTestDrive {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date ngayNhap = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ListHangHoa listHangHoa = new ListHangHoa();
        listHangHoa.DuLieuMacDinh();
        do {
            System.out.println("|>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<|");
            System.out.println("|>>1. Thêm Hàng Hoá!                              |");
            System.out.println("|>>2. Xuất Danh Sách!                             |");
            System.out.println("|>>3. Sửa Hàng Hoá!                               |");
            System.out.println("|>>4. Tìm Hàng Hoá Theo Loại!                     |");
            System.out.println("|>>5. Xoá Hàng Hoá!!                              |");
            System.out.println("|>>6. Sắp Xếp Tăng Dần!!                          |");
            System.out.println("|>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<|");
            System.out.println("Vui Lòng Chọn Chức Năng:");
            int soChon = sc.nextInt();
            sc.nextLine();

            
            switch (soChon) {
                case 1:
                String loaiHh = null;
                sc.nextLine();
                System.out.println("Nhập Tên Hàng:");
                String ten = sc.nextLine();
                System.out.println("Nhập Số Lượng:");
                int soLuong = sc.nextInt();
                System.out.println("Nhập Giá:");
                float gia = sc.nextFloat();
                System.out.println("Nhập Loại Hàng [1: Thực Phẩm; 2: Sành Sứ; 3: Điện Máy]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thực Phẩm";
                    break;
                    case 2: loaiHh = "Sành Sứ";
                    break;
                    case 3: loaiHh = "Điện Máy";
                    break;
                    default: System.out.println("Loại Không Hợp Lệ!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhập Ngày Vào Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngày Không Hợp Lệ!!!!");
                }
                HangHoa hangHoa = new HangHoa(soLuong, ten, loaiHh, gia, ngayNhap);
                listHangHoa.ThemHangHoa(hangHoa);
                    break;
                case 2:
                listHangHoa.HienThiHangHoa();
                    break;
                case 3:
                System.out.println("Nhập ID Cần Sửa:");
                int id = sc.nextInt();
                listHangHoa.SuaThongTin(id);
                    break;
                case 4:
                System.out.println("Nhập Loại Muốn Tìm [1:Thực Phẩm] ; [2: Sành Sứ]; [3: Điện Máy]");
                System.out.println("Nhập Loại Muốn Tìm:");
                int loai = sc.nextInt();
                String ll = null;
                    switch(loai){
                        case 1: ll = "Thực Phẩm";
                        break;
                        case 2: ll = "Sành Sứ";
                        break;
                        case 3: ll = "Điện Máy";
                        break;
                        default: System.out.println("Loại Không Hợp Lệ!!");
                        break;
                    }
                    listHangHoa.TimKiemTheoLoai(ll);
                    break;
                case 5:
                System.out.println("Nhập ID Muốn Xoá:");
                int idx = sc.nextInt();
                listHangHoa.XoaHangHoa(idx);
                break;
                case 6:
                listHangHoa.SapXepTangDan();
                break;
                default:
                    System.out.println("Lựa Chọn Không Hợp Lệ!!!");

            }
        } while (true);
    }
}
