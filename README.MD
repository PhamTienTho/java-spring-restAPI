# 🚀 Java Spring RESTful API

Dự án Java Spring Boot cung cấp các RESTful APIs cơ bản bao gồm xác thực (Authentication), phân quyền, và quản lý người dùng (User Management).  

## 🛠 Công nghệ sử dụng
- **Ngôn ngữ**: Java 25
- **Framework chính**: Spring Boot 4.0.2
- **Thành phần**:
  - Spring Web MVC: Xây dựng RESTful API
  - Spring Data JPA: Giao tiếp với cơ sở dữ liệu
  - Spring Security & OAuth2: Xác thực và phân quyền (JWT)
  - Spring Validation: Validate dữ liệu đầu vào
- **Cơ sở dữ liệu**: MySQL
- **Công cụ build**: Maven
- **Container**: Docker & Docker Compose

## ⚙️ Hướng dẫn cài đặt (Setup)

### 🐳 Cách 1: Chạy bằng Docker (khuyên dùng - chỉ 1 câu lệnh)

Yêu cầu: đã cài [Docker Desktop](https://www.docker.com/products/docker-desktop/).

```bash
git clone <đường-dẫn-repo>
cd Java-Spring-RestAPI
docker compose up -d --build
```

Lệnh này sẽ tự động:
- Build image cho ứng dụng Spring Boot từ `Dockerfile`.
- Khởi chạy MySQL và chờ đến khi database sẵn sàng.
- Khởi chạy ứng dụng và tự kết nối tới MySQL.

Ứng dụng sẽ chạy tại: `http://localhost:8081`

Dừng dự án: `docker compose down` (thêm `-v` nếu muốn xoá luôn dữ liệu database).

### 🛠 Cách 2: Chạy thủ công (không dùng Docker)

**Bước 1: Clone dự án**
```bash
git clone <đường-dẫn-repo>
cd Java-Spring-RestAPI
```

**Bước 2: Cài đặt cơ sở dữ liệu**
1. Đảm bảo MySQL đang chạy.
2. Tạo cơ sở dữ liệu (tên database cấu hình trong `application.properties`).
3. Cập nhật thông tin kết nối database (username, password) trong file `src/main/resources/application.properties`.

**Bước 3: Chạy dự án**
Sử dụng Maven wrapper tích hợp sẵn:
```bash
# Trên Windows
mvnw.cmd spring-boot:run

# Trên Linux/Mac
./mvnw spring-boot:run
```
Dự án sẽ khởi chạy mặc định tại: `http://localhost:8081` (hoặc port bạn cấu hình).

