-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Des 2022 pada 02.36
-- Versi server: 10.4.25-MariaDB
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simak`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(10) NOT NULL,
  `nama_admin` varchar(33) NOT NULL,
  `pass_admin` varchar(33) NOT NULL,
  `telp_admin` varchar(15) NOT NULL,
  `alamat_admin` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `pass_admin`, `telp_admin`, `alamat_admin`) VALUES
('E41220007', 'Maulidatul Muauwanah', '5e8edd851d2fdfbd7415232c67367cc3', '0895323591981', 'Sidoarjo'),
('E41220362', 'Kevin Igor Ibnu Listanto', '5e8edd851d2fdfbd7415232c67367cc3', '081254974619', 'Sidoarjo'),
('E41220523', 'Megawati Putri Martinez', '5e8edd851d2fdfbd7415232c67367cc3', '085232565956', 'Sidoarjo'),
('E41220776', 'Muhammad Abdul Muqid', '5e8edd851d2fdfbd7415232c67367cc3', '085233977851', 'Bondowoso'),
('E41221172', 'Erlangga Lesmana Putra', '5e8edd851d2fdfbd7415232c67367cc3', '082139117365', 'Sidoarjo');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dosen`
--

CREATE TABLE `dosen` (
  `dosen_prodi` varchar(50) NOT NULL,
  `nama_dosen` tinytext NOT NULL,
  `id_dosen` char(10) NOT NULL,
  `alamat` tinytext NOT NULL,
  `nomor_telp` varchar(13) NOT NULL,
  `pass_dosen` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `dosen`
--

INSERT INTO `dosen` (`dosen_prodi`, `nama_dosen`, `id_dosen`, `alamat`, `nomor_telp`, `pass_dosen`) VALUES
('TIF_SDA', 'Ahmad Fahriyannur Rosyady, S.Kom., M.MT', '0003089203', 'Jember', '081222668249', '2603d22b8883b9258601e4c5d9a78d36'),
('TIF_SDA', 'Denny Trias Utomo, S. Si, MT', '0009107104', 'Malang', '081336608000', '2603d22b8883b9258601e4c5d9a78d36'),
('TIF_SDA', 'Adi Sucipto, S,ST., M.TR.T.', '0009280967', 'Nganjuk', '08974884075', '2603d22b8883b9258601e4c5d9a78d36'),
('TIF_SDA', 'Mochammad Rifki Ulil Albab,ST., M.Tr.T.', '0023049404', 'Banyuwangi', '081230942601', '2603d22b8883b9258601e4c5d9a78d36'),
('TIF_SDA', 'Sholihah Ayu Wulandari,S.ST,M.Tr.T.', '0024119301', 'Mojokerto', '085237757412', '2603d22b8883b9258601e4c5d9a78d36');

-- --------------------------------------------------------

--
-- Struktur dari tabel `lomba`
--

CREATE TABLE `lomba` (
  `id_lomba` varchar(10) NOT NULL,
  `kategori_lomba` tinytext NOT NULL,
  `nama_lomba` tinytext NOT NULL,
  `tanggal` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `lomba`
--

INSERT INTO `lomba` (`id_lomba`, `kategori_lomba`, `nama_lomba`, `tanggal`) VALUES
('20220916_1', 'Lomba IOT', 'EPIM JTI', '2022-09-16'),
('20221002_1', 'Lomba TIK', 'GEMASTIK 2022', '2022-10-02'),
('20221009_1', 'Festival musik', 'Smekdors 2022', '2022-10-09');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nama_mahasiswa` varchar(50) NOT NULL,
  `nim` char(9) NOT NULL,
  `alamat` tinytext NOT NULL,
  `nomor_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`nama_mahasiswa`, `nim`, `alamat`, `nomor_telp`) VALUES
('Niskala Argo Maulana', 'E41220005', 'Mojokerto', '085297258558'),
('Maulidatul Muauwanah', 'E41220007', 'Trenggalek', '081942771831'),
('Rasyidah Aisy Ariyanto', 'E41220015', 'Bangil', '08124597897'),
('Hendra Dwi Saputra', 'E41220042', 'Gresik', '088804863124'),
('Muhammad Irfan Zuhri', 'E41220043', 'Jepara', '085810272044'),
('Anindya Griselda ', 'E41220076', 'Pasuruan', '081256785432'),
('Tantio Anugra Almarfais', 'E41220093', 'Sidoarjo', '082235467461'),
('Fitri Dwi Fadilah', 'E41220102', 'Sidoarjo', '0895630254006'),
('Mochammad Rifky Alfiansyah', 'E41220108', 'Sidoarjo', '081245728092'),
('Sasqia Salsabila At Thohir', 'E41220116', 'Pasuruan', '081232463648'),
('Nensyah Permadani', 'E41220243', 'Sidoarjo', '081553857173'),
('Muhammad Yoga Pratama Chusnani', 'E41220273', 'Gresik', '081236275137'),
('Kevin Igor Ibnu Listanto', 'E41220362', 'Sidoarjo', '081254974619'),
('Rendy Dharmaputra', 'E41220415', 'Jember', '085532893412'),
('Nabila Neva Rahmawati', 'E41220422', 'Sidoarjo', '085568736134'),
('Fadhil Pradepta Dhamiri', 'E41220447', 'Tuban', '083119462400'),
('Megawati Putri Martinez', 'E41220523', 'Sidoarjo', '085232565956'),
('Achmad Zaki Maulana', 'E41220583', 'Sidoarjo', '082132347462'),
('Salsabila Syadza Ramadhani', 'E41220631', 'Sidoarjo', '081262738859'),
('Irsyad Romadloni', 'E41220645', 'Jombang', '082334926269'),
('Iqbal Amin', 'E41220723', 'Jombang', '085924315868'),
('Ahmad Affandi', 'E41220775', 'Bondowoso', '081249814055'),
('Muhammad Abdul Muqid', 'E41220776', 'Jember', '085233977851'),
('Muhammad Afifudin', 'E41220777', 'Sidoarjo', '082177378925'),
('Adrian Satrio Hidayatullah', 'E41220828', 'Surabaya', '081231411655'),
('Dimas Aswito ', 'E41220867', 'Mojokerto', '082116848487'),
('Irfan Marzenda ', 'E41220911', 'Surabaya', '085827574623'),
('Achmad Rizqi Taqiyuddin', 'E41221027', 'Malang', '082211803330'),
('Rica Rahmahidayatul', 'E41221149', 'Sidoarjo', '085867426723'),
('Erlangga Lesmana Putra', 'E41221172', 'Sidoarjo', '082139117365'),
('Muhammad Hasyim Al Arif', 'E41221186', 'Pasuruan', '081231008809'),
('Mohammad Dzaki Arifin', 'E41221515', 'Sidoarjo', '081246268723'),
('Mochammad Lury Choirul Rizky', 'E41221566', 'Bangil', '081298267346'),
('Mochamad Ryan Hanafi', 'E41221575', 'Sidoarjo', '081284527346'),
('Faris Rajendra Maulana', 'E41221581', 'Tuban', '081277438369'),
('Muhammad Ilham Firmansyah', 'E41221590', 'Sidoarjo', '081235142623'),
('Muhammad Adam Romadhon', 'E41221615', 'Sidoarjo', '085877652435'),
('Akbar Ilhamsyah', 'E41221683', 'Sidoarjo', '082131450744'),
('Agitha Rizky Aldiansyah', 'E41221692', 'Sidoarjo', '089577857396'),
('Wahyu Putera Maulana', 'E41221736', 'Jombang', '082367158765'),
('Divya Fransiska Maharani', 'E41221768', 'Trenggalek', '085776046430'),
('Vemas Rachmadani Shofiyullah', 'E41221782', 'Mojokerto', '082163258756'),
('Ageng Puji Pangestu', 'E41221811', 'Trenggalek', '082244958864'),
('Zahra Awalia Santosa', 'E41221845', 'Sidoarjo', '0881036213850'),
('Nur Muchlisin Dwi Putro', 'E41221859', 'Mojokerto', '089572239553'),
('Rizki Makhfud Nur Atsani', 'E41221941', 'Sidoarjo', '081262548607'),
('Aryana Ihsan Nuryansyah', 'E41221979', 'Sampang', '082538769758'),
('Adi Pramono Aji', 'E41222050', 'Sidoarjo', '082133894583'),
('Kriesnaldy Aprillian Indharu', 'E41222078', 'Surabaya', '08987563124'),
('Dika Deviardi', 'E41222249', 'Ciamis', '081277339472'),
('Reza Yanuar Rahman', 'E41222258', 'Sidoarjo', '089544783935'),
('Riko Yudha Wastu Aji Hartono', 'E41222718', 'Sidoarjo', '081243227984'),
('Ivan Mahdavikia', 'E41222727', 'Sidoarjo', '081333870598'),
('Muhammad Haris Suhud', 'E41222732', 'Pasuruan', '081358369671'),
('Mohammad Auzie Ivan Nagara', 'E41222798', 'Surabaya', '081259006379'),
('Edward Aqilah Adi Surya', 'E41222800', 'Sidoarjo', '081377492237'),
('Grace Septyana', 'E41222805', 'Lampung', '085841351405'),
('Igfirlii Nuur Aziiza', 'E41222837', 'Probolinggo', '089537842288'),
('Dimas Bayu Putra Rismawan', 'E41222872', 'Surabaya', '081238749523'),
('Reza Andyah Wijaya', 'E41222886', 'Sidoarjo', '085877658987'),
('Dita Emi Alfiani', 'E41222907', 'Pasuruan', '081276457644');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa_mid`
--

CREATE TABLE `mahasiswa_mid` (
  `nama_mahasiswa` tinytext NOT NULL,
  `nim` char(9) NOT NULL,
  `alamat` tinytext NOT NULL,
  `nomor_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mahasiswa_mid`
--

INSERT INTO `mahasiswa_mid` (`nama_mahasiswa`, `nim`, `alamat`, `nomor_telp`) VALUES
('Bima Hidayah Putra', 'D41220087', 'Sidoarjo', '082122568746'),
('Gizzeo Ogjha Bima Subekti', 'D41220978', 'Sidoarjo', '082188238843'),
('Aritiya Liawidiyanti Hermini', 'D41224465', 'Sidoarjo', '082138887364'),
('Danendra Proboananta', 'D41225276', 'Sidoarjo', '0899222347'),
('Anggi Oktavia', 'D41226439', 'Sidoarjo', '085583989925'),
('Anik Zahriyah ', 'D41227227', 'Sidoarjo', '088268795277'),
('Wafiq Nur Azizah', 'D41227562', 'Sidoarjo', '082122534298'),
('Meidi Indah Sari', 'D41227783', 'Sidoarjo', '083289386736'),
('Rizki Dewanto Utomo', 'D41227980', 'Sidoarjo', '088125369978'),
('Risma', 'D41228304', 'Sidoarjo', '082278379042'),
('Aimar Huda', 'D41228309', 'Sidoarjo', '088273952278'),
('Siti Eka Nur Julianti', 'D41228423', 'Sidoarjo', '087825386287'),
('Monik Permata Nur Azizah', 'D41228767', 'Sidoarjo', '082188387284'),
('Sintya Tri Wahyuni', 'D41228909', 'Sidoarjo', '088122128972'),
('Ririn Nur Aprilia', 'D41229078', 'Sidoarjo', '088235472298'),
('Muhammad Dhawy', 'D41229298', 'Sidoarjo', '082182898897'),
('Muhammad Luthfi Khumaidi', 'D41229387', 'Sidoarjo', '082188308297'),
('Dito Dwi Prasetya', 'D41229389', 'Sidoarjo', '081222893238'),
('Dzurrotun Nafisah', 'D41229708', 'Sidoarjo', '088153268679'),
('Muhammad Abid Muzayyin', 'D41229786', 'Sidoarjo', '085877897253'),
('Kaila Tirta Tri Meifa', 'D41229876', 'Sidoarjo', '082155278294');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `id_matkul` varchar(12) NOT NULL,
  `matkul_prodi` varchar(5) NOT NULL,
  `nama_matkul` varchar(50) NOT NULL,
  `ruang_matkul` varchar(17) NOT NULL,
  `durasi_matkul` varchar(27) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`id_matkul`, `matkul_prodi`, `nama_matkul`, `ruang_matkul`, `durasi_matkul`) VALUES
('TIFSDA110701', 'TIF', 'Pendidikan Agama Islam', 'Aula', '2 Jam(120 Menit)'),
('TIFSDA110702', 'TIF', 'Pancasila', 'Aula', '2 Jam(120 Menit)'),
('TIFSDA110703', 'TIF', 'Basic English', 'Aula', '3 Jam(180 Menit)'),
('TIFSDA110704', 'TIF', 'Logika dan Algoritma', 'Aula', '2 Jam(120 Menit)'),
('TIFSDA110705', 'TIF', 'Konsep Basis Data', 'Aula', '2 Jam(120 Menit)'),
('TIFSDA110706', 'TIF', 'Pemrograman Dasar', 'Aula', '2 Jam(120 Menit)'),
('TIFSDA110707', 'TIF', 'Workshop Pengembangan Perangkat Lunak', 'Lab RSI dan SKK', '4 Jam(240 Menit)'),
('TIFSDA110708', 'TIF', 'Workshop Basis Data', 'Lab RSI dan SKK', '4 Jam(240 Menit)');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mata_kuliah_mid`
--

CREATE TABLE `mata_kuliah_mid` (
  `id_matkul` varchar(9) NOT NULL,
  `matkul_prodi` varchar(5) NOT NULL,
  `nama_matkul` varchar(50) NOT NULL,
  `ruang_matkul` varchar(17) NOT NULL,
  `durasi_matkul` varchar(27) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mata_kuliah_mid`
--

INSERT INTO `mata_kuliah_mid` (`id_matkul`, `matkul_prodi`, `nama_matkul`, `ruang_matkul`, `durasi_matkul`) VALUES
('101', 'MID', 'Pengantar Ilmu Ekonomi', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('102', 'MID', 'Pengantar Bisnis', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('103', 'MID', 'Dasar - Dasar Manajemen', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('104', 'MID', 'Pancasila', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('105', 'MID', 'Sosiologi Industri', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('106', 'MID', 'Dasar - Dasar Akuntansi', 'PSDKU Kelas 101', '1 Jam (60 menit)'),
('107', 'MID', 'Praktik Dasar - Dasar Akuntansi', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('108', 'MID', 'Pengantar Agroindustri', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('109', 'MID', 'Agama', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('110', 'MID', 'Matematika Ekonomi', 'PSDKU Kelas 101', '2 jam (120 menit)'),
('111', 'MID', 'Basic english', 'PSDKU Kelas 101', '1 Jam (60 menit)'),
('112', 'MID', 'Praktik Basic English', 'PSDKU Kelas 101', '2 jam (120 menit)');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penelitian`
--

CREATE TABLE `penelitian` (
  `id_penelitian` varchar(15) NOT NULL,
  `kategori_penelitian` varchar(30) NOT NULL,
  `nama_penelitian` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penelitian`
--

INSERT INTO `penelitian` (`id_penelitian`, `kategori_penelitian`, `nama_penelitian`) VALUES
('P202211230', 'Greenhouse ', 'Penelitian Greenhouse'),
('P20221123002', 'Lobster', 'Penelitian Lobster Air Tawar');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengabdian_masyarakat`
--

CREATE TABLE `pengabdian_masyarakat` (
  `id_pengabdian` varchar(15) NOT NULL,
  `kegiatan` tinytext NOT NULL,
  `lokasi` tinytext NOT NULL,
  `tanggal` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengabdian_masyarakat`
--

INSERT INTO `pengabdian_masyarakat` (`id_pengabdian`, `kegiatan`, `lokasi`, `tanggal`) VALUES
('PM20220906001', 'Program Kemitraan masyarakat', 'Desa Sepande RT 14 RW 04 Candi Sidoarjo', '2022-09-06'),
('PM20221002001', 'Penyuluhan Teknologi Kampung Tangguh', 'Pondok Sidokare Indah', '2022-10-02');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`id_dosen`);

--
-- Indeks untuk tabel `lomba`
--
ALTER TABLE `lomba`
  ADD PRIMARY KEY (`id_lomba`);

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indeks untuk tabel `mahasiswa_mid`
--
ALTER TABLE `mahasiswa_mid`
  ADD PRIMARY KEY (`nim`);

--
-- Indeks untuk tabel `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`id_matkul`);

--
-- Indeks untuk tabel `mata_kuliah_mid`
--
ALTER TABLE `mata_kuliah_mid`
  ADD PRIMARY KEY (`id_matkul`);

--
-- Indeks untuk tabel `penelitian`
--
ALTER TABLE `penelitian`
  ADD PRIMARY KEY (`id_penelitian`);

--
-- Indeks untuk tabel `pengabdian_masyarakat`
--
ALTER TABLE `pengabdian_masyarakat`
  ADD PRIMARY KEY (`id_pengabdian`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
