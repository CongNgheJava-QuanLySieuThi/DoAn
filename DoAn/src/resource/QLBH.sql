CREATE DATABASE QL_BH;
GO
USE QL_BH;
GO
CREATE TABLE [NGUOIDUNG] (
  MAND BIGINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  HO NVARCHAR(MAX) NULL,
  TEN NVARCHAR(MAX) NOT NULL,
  TENTAIKHOAN NVARCHAR(MAX) NOT NULL,
  MATKHAU NVARCHAR(MAX) NOT NULL,
  CHUCVU NVARCHAR(MAX) NOT NULL,
  NGAYTAO DATETIME2 DEFAULT GETDATE() NOT NULL,
  NGAYCAPNHAT DATETIME2 DEFAULT GETDATE() NOT NULL
);
GO

CREATE TABLE [DANHMUC] (
  MADANHMUC BIGINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  TENDANHMUC NVARCHAR(MAX) NOT NULL,
  NGAYTAO DATETIME2 DEFAULT GETDATE() NOT NULL
);
GO

CREATE TABLE [SANPHAM] (
  MASP BIGINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  TENSP NVARCHAR(MAX) NOT NULL,
  GIA DECIMAL DEFAULT 0 NULL,
  GIAMGIA INT DEFAULT 0 NULL,
  HINHANH NVARCHAR(MAX) NULL,
  TUKHOA NVARCHAR(MAX) NOT NULL, -- khong hien thi len giao dien
  MOTA NVARCHAR(MAX) NULL,
  SOLUONGTONKHO INT DEFAULT 0 NOT NULL,
  NGAYTAO DATETIME2 DEFAULT GETDATE() NOT NULL,
  NGAYCAPNHAT DATETIME2 DEFAULT GETDATE() NOT NULL,
  MADANHMUC BIGINT NOT NULL,
  CONSTRAINT FK_SANPHAM_DANHMUC FOREIGN KEY (MADANHMUC) REFERENCES [DANHMUC](MADANHMUC)
);
GO

CREATE TABLE [DONHANG] (
  MADONHANG BIGINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  TENDONHANG NVARCHAR(MAX) NOT NULL,
  TONGTIEN DECIMAL DEFAULT 0 NOT NULL,
  TONGGIAMGIA DECIMAL DEFAULT 0 NOT NULL,
  NGAYTAO DATETIME2 DEFAULT GETDATE() NOT NULL,
  MAND BIGINT NOT NULL,
  CONSTRAINT FK_DONHANG_NGUOIDUNG FOREIGN KEY (MAND) REFERENCES [NGUOIDUNG](MAND)
);
GO

CREATE TABLE [MUCDONHANG] (
  MAMUC BIGINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  SOLUONG INT DEFAULT 0 NOT NULL,
  GIAHIENTAI DECIMAL DEFAULT 0 NOT NULL,
  GIAMGIAHIENTAI DECIMAL DEFAULT 0 NOT NULL,
  MADONHANG BIGINT NOT NULL,
  MASP BIGINT NOT NULL,
  CONSTRAINT FK_MUCDONHANG_DONHANG FOREIGN KEY (MADONHANG) REFERENCES [DONHANG](MADONHANG),
  CONSTRAINT FK_MUCDONHANG_SANPHAM FOREIGN KEY (MASP) REFERENCES [SANPHAM](MASP)
);
GO

CREATE TABLE [HOADON] (
  MAHD BIGINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  TENHOADON NVARCHAR(MAX) NOT NULL,
  PHUONGTHUCMUAHANG NVARCHAR(MAX) NULL,
  MADONHANG BIGINT NOT NULL,
  MAND BIGINT NOT NULL,
  NGAYTAO DATETIME2 NOT NULL,
  CONSTRAINT FK_HOADON_DONHANG FOREIGN KEY (MADONHANG) REFERENCES [DONHANG](MADONHANG),
  CONSTRAINT FK_HOADON_NGUOIDUNG FOREIGN KEY (MAND) REFERENCES [NGUOIDUNG](MAND)
);
GO

CREATE TABLE [HANGTONKHO] (
  MAHTK BIGINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  SOLUONGTRONGKHO BIGINT NOT NULL,
  NGAYNHAPHANG DATETIME2 NOT NULL,
  NGAYXUATHANG DATETIME2,
  TRANGTHAI NVARCHAR(MAX),
  MASP BIGINT NOT NULL,
  CONSTRAINT FK_HANGTONKHO_SANPHAM FOREIGN KEY (MASP) REFERENCES [SANPHAM](MASP),
)
GO

-- Chèn dữ liệu mẫu vào bảng NGUOIDUNG (Người dùng)
INSERT INTO NGUOIDUNG (HO, TEN, TENTAIKHOAN, MATKHAU, CHUCVU)
VALUES (N'Nguyễn', N'Văn A', 'user1', 'password1', N'Nhân viên'),
       (N'Trần', N'Thị B', 'user2', 'password2', N'Quản lý'),
       (N'Lê', N'Hoa C', 'user3', 'password3', N'Quản trị viên'),
       (N'Phạm', N'Duy D', 'user4', 'password4', N'Nhân viên'),
       (N'Hoàng', N'Mai E', 'user5', 'password5', N'Quản lý'),
       (N'Đặng', N'Quốc F', 'user6', 'password6', N'Nhân viên'),
       (N'Nguyễn',N'Thị G', 'user7', 'password7', N'Quản trị viên');

go

-- Chèn dữ liệu mẫu vào bảng DANHMUC (Danh mục)
INSERT INTO DANHMUC (TENDANHMUC)
VALUES (N'Điện tử'),
       (N'Quần áo'),
       (N'Sách'),
       (N'Đồ gia dụng'),
       (N'Thực phẩm'),
       (N'Đồ chơi'),
       (N'Mỹ phẩm');
go



-- Chèn dữ liệu mẫu vào bảng SANPHAM (Sản phẩm)
INSERT INTO SANPHAM (TENSP, GIA, GIAMGIA, HINHANH, TUKHOA, MOTA, SOLUONGTONKHO, MADANHMUC)
VALUES (N'Điện thoại thông minh', 500, 10, 'dienthoai.jpg', N'điện thoại, smartphone', N'Điện thoại thông minh chất lượng cao', 100, 1),
       (N'Áo thun', 20, 5, 'aothun.jpg', N'áo thun, quần áo', N'Áo thun cotton thoải mái', 200, 2),
       (N'Tiểu thuyết', 15, 3, 'tieuthuyet.jpg', N'tiểu thuyết, sách', N'Tiểu thuyết bán chạy nhất', 50, 3),
       (N'Bàn là', 300, 20, 'banla.jpg', N'bàn là, đồ gia dụng', N'Bàn là cao cấp', 80, 4),
       (N'Gạo', 10, 0, 'gao.jpg', N'gạo, thực phẩm', N'Gạo ngon', 150, 5),
       (N'Xe đạp', 150, 10, 'xedap.jpg', N'xe đạp, đồ chơi', N'Xe đạp cho trẻ em', 30, 6),
       (N'Son môi', 25, 5, 'sonmoi.jpg', N'son môi, mỹ phẩm', N'Son môi chất lượng', 100, 7);
go


-- Chèn dữ liệu mẫu vào bảng DONHANG (Đơn hàng)
INSERT INTO DONHANG (TENDONHANG, TONGTIEN, TONGGIAMGIA, MAND)
VALUES (N'Đơn hàng 1', 450, 15, 1),
       (N'Đơn hàng 2', 100, 5, 2),
       (N'Đơn hàng 3', 30, 2, 3),
       (N'Đơn hàng 4', 600, 30, 4),
       (N'Đơn hàng 5', 200, 10, 5),
       (N'Đơn hàng 6', 50, 3, 6),
       (N'Đơn hàng 7', 80, 5, 7);
go


-- Chèn dữ liệu mẫu vào bảng MUCDONHANG (Chi tiết đơn hàng)
INSERT INTO MUCDONHANG (SOLUONG, GIAHIENTAI, GIAMGIAHIENTAI, MADONHANG, MASP)
VALUES (2, 250, 5, 1, 1),
       (3, 15, 1, 2, 3),
       (1, 20, 0, 3, 2),
       (4, 75, 15, 4, 4),
       (5, 8, 1, 5, 5),
       (2, 120, 10, 6, 6),
       (1, 30, 2, 7, 7);
go


-- Chèn dữ liệu mẫu vào bảng HOADON (Hóa đơn)
INSERT INTO HOADON (TENHOADON, PHUONGTHUCMUAHANG, MADONHANG, MAND, NGAYTAO)
VALUES (N'Hóa đơn 1', N'Tiền mặt', 1, 1, GETDATE()),
       (N'Hóa đơn 2', N'Thẻ tín dụng', 2, 2, GETDATE()),
       (N'Hóa đơn 3', N'PayPal', 3, 3, GETDATE()),
       (N'Hóa đơn 4', N'Tiền mặt', 4, 4, GETDATE()),
       (N'Hóa đơn 5', N'Thẻ tín dụng', 5, 5, GETDATE()),
       (N'Hóa đơn 6', N'PayPal', 6, 6, GETDATE()),
       (N'Hóa đơn 7', N'Tiền mặt', 7, 7, GETDATE());
go


-- Chèn dữ liệu mẫu vào bảng HANGTONKHO (Hàng tồn kho)
INSERT INTO HANGTONKHO (SOLUONGTRONGKHO, NGAYNHAPHANG, NGAYXUATHANG, TRANGTHAI, MASP)
VALUES (50, GETDATE(), NULL, 'Trong kho', 1),
       (150, GETDATE(), NULL, 'Trong kho', 2),
       (20, GETDATE(), NULL, 'Trong kho', 3),
       (40, GETDATE(), NULL, 'Trong kho', 4),
       (100, GETDATE(), NULL, 'Trong kho', 5),
       (10, GETDATE(), NULL, 'Trong kho', 6),
       (60, GETDATE(), NULL, 'Trong kho', 7);
