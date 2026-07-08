package vn.tientho.spring_test.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vn.tientho.spring_test.dto.response.ApiResponse;
import vn.tientho.spring_test.model.User;
import vn.tientho.spring_test.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getHomePage() {
        return ResponseEntity.ok("Hello World");
    }

    // GET /users - lấy tất cả users
    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Lấy danh sách người dùng thành công", users));
    }

    // GET /users/{id} - lấy user theo id
    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        User user = this.userService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.success("Lấy thông tin người dùng thành công", user));
    }

    // POST /users - tạo user mới
    @PostMapping("/users")
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody User user) {
        User createdUser = this.userService.createUser(user);
        URI location = URI.create("/users/" + createdUser.getId());
        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(
            ApiResponse.created("Tạo người dùng mới thành công", createdUser));
    }

    // PUT /users/{id} - cập nhật user
    @PutMapping("/users/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@Valid @PathVariable Long id, @RequestBody User user) {
        User updatedUser = this.userService.updateUser(user,id);
        return ResponseEntity.ok(ApiResponse.success("Cập nhật thông tin người dùng thành công", updatedUser));
    }

    // DELETE /users/{id} - xóa user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
