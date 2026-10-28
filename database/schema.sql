CREATE DATABASE IF NOT EXISTS book_issue_tracker CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE book_issue_tracker;

CREATE TABLE IF NOT EXISTS books (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL,
  author VARCHAR(150) NOT NULL,
  isbn VARCHAR(30) UNIQUE,
  total_copies INT NOT NULL DEFAULT 1,
  available_copies INT NOT NULL DEFAULT 1,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CHECK (total_copies >= 1), CHECK (available_copies >= 0), CHECK (available_copies <= total_copies)
);
CREATE TABLE IF NOT EXISTS borrowers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  full_name VARCHAR(150) NOT NULL,
  email VARCHAR(180),
  phone VARCHAR(30),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS issues (
  id INT PRIMARY KEY AUTO_INCREMENT,
  book_id INT NOT NULL,
  borrower_id INT NOT NULL,
  issue_date DATE NOT NULL,
  due_date DATE NOT NULL,
  return_date DATE NULL,
  status ENUM('ISSUED','RETURNED') NOT NULL DEFAULT 'ISSUED',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_issue_book FOREIGN KEY (book_id) REFERENCES books(id),
  CONSTRAINT fk_issue_borrower FOREIGN KEY (borrower_id) REFERENCES borrowers(id),
  CHECK (due_date >= issue_date)
);
INSERT IGNORE INTO books(title,author,isbn,total_copies,available_copies) VALUES
('Wings of Fire','A. P. J. Abdul Kalam','9788173711466',3,3),
('The Guide','R. K. Narayan','9780143039648',2,2);
