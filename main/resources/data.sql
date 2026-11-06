-- =====================================================================
-- data.sql  : DEV / DEMO seed data.  Runs automatically on the in-memory H2 database.
-- All people, schools and ID numbers below are FICTIONAL.
-- Dev logins:  admin01 / Admin@1234     teacher@demo-school.ac.th / Teacher@1234
-- NEVER keep these accounts on the real (GCP) database: change/delete them.
-- Order matters: parents first, children after (foreign keys).
-- Tables with auto-increment ids are inserted WITHOUT id and referenced by a natural key.
-- =====================================================================

-- 1) geography (SAMPLE ONLY - load the full Thai province/district/subdistrict CSV later)
INSERT INTO province (province_id, name, region) VALUES (57, 'Chiang Rai', 'North');
INSERT INTO province (province_id, name, region) VALUES (50, 'Chiang Mai', 'North');
INSERT INTO province (province_id, name, region) VALUES (10, 'Bangkok', 'Central');

INSERT INTO district (district_id, province_id, name) VALUES (5701, 57, 'Mueang Chiang Rai');
INSERT INTO district (district_id, province_id, name) VALUES (5001, 50, 'Mueang Chiang Mai');
INSERT INTO district (district_id, province_id, name) VALUES (1001, 10, 'Phra Nakhon');

INSERT INTO subdistrict (subdistrict_id, district_id, name, zipcode) VALUES (570101, 5701, 'Wiang', '57000');
INSERT INTO subdistrict (subdistrict_id, district_id, name, zipcode) VALUES (570102, 5701, 'Rop Wiang', '57000');
INSERT INTO subdistrict (subdistrict_id, district_id, name, zipcode) VALUES (500101, 5001, 'Si Phum', '50200');
INSERT INTO subdistrict (subdistrict_id, district_id, name, zipcode) VALUES (100101, 1001, 'Phra Borom Maha Ratchawang', '10200');

-- 2) lookups
INSERT INTO prefix (prefix_name) VALUES ('นาย');
INSERT INTO prefix (prefix_name) VALUES ('นาง');
INSERT INTO prefix (prefix_name) VALUES ('นางสาว');
INSERT INTO prefix (prefix_name) VALUES ('ดร.');
INSERT INTO prefix (prefix_name) VALUES ('ผศ.');

-- status codes follow the note in the ERD (confirm the exact list with the Admission Division)
INSERT INTO applicant_status (status_code, description) VALUES (10, 'Applied');
INSERT INTO applicant_status (status_code, description) VALUES (20, 'Eligible for examination/interview');
INSERT INTO applicant_status (status_code, description) VALUES (40, 'Selected');
INSERT INTO applicant_status (status_code, description) VALUES (41, 'Selected - not registered');
INSERT INTO applicant_status (status_code, description) VALUES (42, 'Selected - registered, rights waived');
INSERT INTO applicant_status (status_code, description) VALUES (43, 'Rights waiver cancelled');
INSERT INTO applicant_status (status_code, description) VALUES (50, 'Registration fee paid (enrolled)');

INSERT INTO quota (quota_name, faculty) VALUES ('Regional Quota', 'Applied Digital Technology');
INSERT INTO quota (quota_name, faculty) VALUES ('Guidance Teacher Quota', 'Applied Digital Technology');

INSERT INTO entrygroup (academic_year, entrygroup_name, apply_start_date, apply_end_date, result_announce_date, rights_confirm_date)
VALUES (2026, 'Quota Round', '2026-12-01', '2027-01-31', '2027-02-10', '2027-02-20');
INSERT INTO entrygroup (academic_year, entrygroup_name, apply_start_date, apply_end_date, result_announce_date, rights_confirm_date)
VALUES (2026, 'Portfolio Round', '2026-09-01', '2026-11-30', '2026-12-15', '2026-12-25');

INSERT INTO program (entrygroup_id, program_name, faculty, description)
VALUES ((SELECT entrygroup_id FROM entrygroup WHERE academic_year = 2026 AND entrygroup_name = 'Quota Round'),
        'Computer Science', 'School of Applied Digital Technology', 'Sample program for demo.');
INSERT INTO program (entrygroup_id, program_name, faculty, description)
VALUES ((SELECT entrygroup_id FROM entrygroup WHERE academic_year = 2026 AND entrygroup_name = 'Quota Round'),
        'Digital Business', 'School of Applied Digital Technology', 'Sample program for demo.');
INSERT INTO program (entrygroup_id, program_name, faculty, description)
VALUES ((SELECT entrygroup_id FROM entrygroup WHERE academic_year = 2026 AND entrygroup_name = 'Portfolio Round'),
        'Computer Science', 'School of Applied Digital Technology', 'Sample program for demo.');

-- 3) schools, accounts
INSERT INTO school (school_code, name, school_type, subdistrict_id) VALUES ('1057010001', 'Chiang Rai Demo School', 'Public', 570101);
INSERT INTO school (school_code, name, school_type, subdistrict_id) VALUES ('1050010001', 'Chiang Mai Demo School', 'Private', 500101);
INSERT INTO school (school_code, name, school_type, subdistrict_id) VALUES ('1010010001', 'Bangkok Demo School', 'Public', 100101);

INSERT INTO admin (username, password_hash, full_name, admin_role)
VALUES ('admin01', '$2b$10$RBtfTL03vBCEeBWa/tFWPe.FjlprR8ZRN8h6koo6.1AkUzxKnAba.', 'Demo Admin', 'ADMIN');

INSERT INTO guidance_teacher (school_id, prefix_id, first_name, last_name, position_title, phone, email, username,
                              password_hash, pdpa_consent, is_email_verified, registered_at, active_academic_year)
VALUES ((SELECT school_id FROM school WHERE school_code = '1057010001'),
        (SELECT prefix_id FROM prefix WHERE prefix_name = 'นาง'),
        'Demo', 'Teacher', 'Head of Guidance', '0800000000', 'teacher@demo-school.ac.th', 'demoteacher',
        '$2b$10$L.u4muiZIWTpy8H1wa02me1oKguKAFnSPLcSb5xLJOlvPBW78TGkG', TRUE, TRUE, '2026-10-26', 2026);

-- 4) posts (third one is already expired -> must NOT show up: tests FR-23)
INSERT INTO post (admin_id, title, content, subdistrict_id, building_name, event_start_date, event_end_date,
                  visible_start_date, visible_end_date, post_type, published_at, is_hidden)
VALUES ((SELECT admin_id FROM admin WHERE username = 'admin01'), 'Quota round opens soon',
        'Application information for the quota round.', 570101, 'Main Building', '2026-12-01', '2027-01-31',
        '2026-10-25', '2026-12-31', 'ANNOUNCEMENT', '2026-10-25 09:00:00', FALSE);
INSERT INTO post (admin_id, title, content, visible_start_date, visible_end_date, post_type, published_at, is_hidden)
VALUES ((SELECT admin_id FROM admin WHERE username = 'admin01'), 'University open house',
        'Open house news for guidance teachers.', '2026-10-01', '2026-12-31', 'NEWS', '2026-10-01 08:00:00', FALSE);
INSERT INTO post (admin_id, title, content, visible_start_date, visible_end_date, post_type, published_at, is_hidden)
VALUES ((SELECT admin_id FROM admin WHERE username = 'admin01'), 'Old promotion (expired)',
        'This post ended already.', '2026-09-01', '2026-10-31', 'PR', '2026-09-01 08:00:00', FALSE);

INSERT INTO post_registration (post_id, teacher_id, registered_at)
VALUES ((SELECT post_id FROM post WHERE title = 'Quota round opens soon'),
        (SELECT teacher_id FROM guidance_teacher WHERE email = 'teacher@demo-school.ac.th'), '2026-10-26 10:30:00');
INSERT INTO post_pin (teacher_id, post_id, pinned_at)
VALUES ((SELECT teacher_id FROM guidance_teacher WHERE email = 'teacher@demo-school.ac.th'),
        (SELECT post_id FROM post WHERE title = 'University open house'), '2026-10-27 08:15:00');

-- 5) applicants (fictional ID numbers) and their applications
INSERT INTO applicant (school_id, national_id, first_name, last_name, academic_year, term)
VALUES ((SELECT school_id FROM school WHERE school_code = '1057010001'), '1000000000011', 'Avan', 'Kole', 2026, 'Term 1');
INSERT INTO applicant (school_id, national_id, first_name, last_name, academic_year, term)
VALUES ((SELECT school_id FROM school WHERE school_code = '1057010001'), '1000000000022', 'Mali', 'Suksan', 2026, 'Term 1');
INSERT INTO applicant (school_id, national_id, first_name, last_name, academic_year, term)
VALUES ((SELECT school_id FROM school WHERE school_code = '1050010001'), '1000000000033', 'Somchai', 'Jaidee', 2026, 'Term 1');
INSERT INTO applicant (school_id, national_id, first_name, last_name, academic_year, term)
VALUES ((SELECT school_id FROM school WHERE school_code = '1010010001'), '1000000000044', 'Nok', 'Rungrueang', 2026, 'Term 1');

INSERT INTO program_interest (applicant_id, program_id, interested_at)
VALUES ((SELECT applicant_id FROM applicant WHERE national_id = '1000000000011'),
        (SELECT p.program_id FROM program p JOIN entrygroup e ON e.entrygroup_id = p.entrygroup_id
          WHERE p.program_name = 'Computer Science' AND e.entrygroup_name = 'Quota Round'), '2026-10-20 14:00:00');
INSERT INTO program_interest (applicant_id, program_id, interested_at)
VALUES ((SELECT applicant_id FROM applicant WHERE national_id = '1000000000022'),
        (SELECT p.program_id FROM program p JOIN entrygroup e ON e.entrygroup_id = p.entrygroup_id
          WHERE p.program_name = 'Digital Business' AND e.entrygroup_name = 'Quota Round'), '2026-10-21 09:30:00');
INSERT INTO program_interest (applicant_id, program_id, interested_at)
VALUES ((SELECT applicant_id FROM applicant WHERE national_id = '1000000000033'),
        (SELECT p.program_id FROM program p JOIN entrygroup e ON e.entrygroup_id = p.entrygroup_id
          WHERE p.program_name = 'Computer Science' AND e.entrygroup_name = 'Quota Round'), '2026-10-21 10:00:00');

INSERT INTO result_dataset (admin_id, program_id, file_name, uploaded_at, total_rows, error_rows, dataset_status, error_summary)
VALUES ((SELECT admin_id FROM admin WHERE username = 'admin01'),
        (SELECT p.program_id FROM program p JOIN entrygroup e ON e.entrygroup_id = p.entrygroup_id
          WHERE p.program_name = 'Computer Science' AND e.entrygroup_name = 'Quota Round'),
        'cs_quota_2026.csv', '2027-02-09 16:00:00', 3, 0, 'PUBLISHED', NULL);

INSERT INTO applicant_selection (applicant_id, entrygroup_id, quota_id, program_id, status_code, applied_at, admin_id, dataset_id, published_at)
VALUES ((SELECT applicant_id FROM applicant WHERE national_id = '1000000000011'),
        (SELECT entrygroup_id FROM entrygroup WHERE entrygroup_name = 'Quota Round'),
        (SELECT quota_id FROM quota WHERE quota_name = 'Regional Quota'),
        (SELECT p.program_id FROM program p JOIN entrygroup e ON e.entrygroup_id = p.entrygroup_id
          WHERE p.program_name = 'Computer Science' AND e.entrygroup_name = 'Quota Round'),
        40, '2026-12-15',
        (SELECT admin_id FROM admin WHERE username = 'admin01'),
        (SELECT dataset_id FROM result_dataset WHERE file_name = 'cs_quota_2026.csv'), '2027-02-10 09:00:00');
INSERT INTO applicant_selection (applicant_id, entrygroup_id, quota_id, program_id, status_code, applied_at)
VALUES ((SELECT applicant_id FROM applicant WHERE national_id = '1000000000022'),
        (SELECT entrygroup_id FROM entrygroup WHERE entrygroup_name = 'Quota Round'),
        (SELECT quota_id FROM quota WHERE quota_name = 'Regional Quota'),
        (SELECT p.program_id FROM program p JOIN entrygroup e ON e.entrygroup_id = p.entrygroup_id
          WHERE p.program_name = 'Digital Business' AND e.entrygroup_name = 'Quota Round'),
        20, '2026-12-16');
INSERT INTO applicant_selection (applicant_id, entrygroup_id, quota_id, program_id, status_code, applied_at)
VALUES ((SELECT applicant_id FROM applicant WHERE national_id = '1000000000033'),
        (SELECT entrygroup_id FROM entrygroup WHERE entrygroup_name = 'Quota Round'),
        (SELECT quota_id FROM quota WHERE quota_name = 'Guidance Teacher Quota'),
        (SELECT p.program_id FROM program p JOIN entrygroup e ON e.entrygroup_id = p.entrygroup_id
          WHERE p.program_name = 'Computer Science' AND e.entrygroup_name = 'Quota Round'),
        10, '2026-12-17');
