--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2016-04-25 20:11:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 185 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 185
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 42823)
-- Name: administrator; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE administrator (
    administrator_id bigint NOT NULL,
    administratortype character varying(20) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE administrator OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 42821)
-- Name: administrator_administrator_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE administrator_administrator_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE administrator_administrator_id_seq OWNER TO postgres;

--
-- TOC entry 2079 (class 0 OID 0)
-- Dependencies: 172
-- Name: administrator_administrator_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE administrator_administrator_id_seq OWNED BY administrator.administrator_id;


--
-- TOC entry 175 (class 1259 OID 42836)
-- Name: feedback; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE feedback (
    feedback_id bigint NOT NULL,
    content text NOT NULL,
    feedbackstatus character varying(20) NOT NULL,
    feedbacktype character varying(20) NOT NULL,
    normaluser_id bigint
);


ALTER TABLE feedback OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 42834)
-- Name: feedback_feedback_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE feedback_feedback_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE feedback_feedback_id_seq OWNER TO postgres;

--
-- TOC entry 2080 (class 0 OID 0)
-- Dependencies: 174
-- Name: feedback_feedback_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE feedback_feedback_id_seq OWNED BY feedback.feedback_id;


--
-- TOC entry 177 (class 1259 OID 42844)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE item (
    item_id bigint NOT NULL,
    level integer NOT NULL,
    type character varying(255) NOT NULL,
    player_id bigint
);


ALTER TABLE item OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 42842)
-- Name: item_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE item_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE item_item_id_seq OWNER TO postgres;

--
-- TOC entry 2081 (class 0 OID 0)
-- Dependencies: 176
-- Name: item_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE item_item_id_seq OWNED BY item.item_id;


--
-- TOC entry 179 (class 1259 OID 42852)
-- Name: news; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE news (
    news_id bigint NOT NULL,
    content text NOT NULL,
    image character varying(255) NOT NULL,
    title character varying(255) NOT NULL,
    administrator_id bigint
);


ALTER TABLE news OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 42850)
-- Name: news_news_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE news_news_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE news_news_id_seq OWNER TO postgres;

--
-- TOC entry 2082 (class 0 OID 0)
-- Dependencies: 178
-- Name: news_news_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE news_news_id_seq OWNED BY news.news_id;


--
-- TOC entry 181 (class 1259 OID 42863)
-- Name: normaluser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE normaluser (
    normaluser_id bigint NOT NULL,
    player_id bigint NOT NULL
);


ALTER TABLE normaluser OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 42871)
-- Name: normaluser_normaluser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE normaluser_normaluser (
    user0 bigint NOT NULL,
    friend bigint NOT NULL
);


ALTER TABLE normaluser_normaluser OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 42861)
-- Name: normaluser_normaluser_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE normaluser_normaluser_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE normaluser_normaluser_id_seq OWNER TO postgres;

--
-- TOC entry 2083 (class 0 OID 0)
-- Dependencies: 180
-- Name: normaluser_normaluser_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE normaluser_normaluser_id_seq OWNED BY normaluser.normaluser_id;


--
-- TOC entry 184 (class 1259 OID 42876)
-- Name: player; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE player (
    player_id bigint NOT NULL,
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    score integer NOT NULL
);


ALTER TABLE player OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 42874)
-- Name: player_player_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE player_player_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE player_player_id_seq OWNER TO postgres;

--
-- TOC entry 2084 (class 0 OID 0)
-- Dependencies: 183
-- Name: player_player_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE player_player_id_seq OWNED BY player.player_id;


--
-- TOC entry 1919 (class 2604 OID 42826)
-- Name: administrator_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY administrator ALTER COLUMN administrator_id SET DEFAULT nextval('administrator_administrator_id_seq'::regclass);


--
-- TOC entry 1920 (class 2604 OID 42839)
-- Name: feedback_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback ALTER COLUMN feedback_id SET DEFAULT nextval('feedback_feedback_id_seq'::regclass);


--
-- TOC entry 1921 (class 2604 OID 42847)
-- Name: item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item ALTER COLUMN item_id SET DEFAULT nextval('item_item_id_seq'::regclass);


--
-- TOC entry 1922 (class 2604 OID 42855)
-- Name: news_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY news ALTER COLUMN news_id SET DEFAULT nextval('news_news_id_seq'::regclass);


--
-- TOC entry 1923 (class 2604 OID 42866)
-- Name: normaluser_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY normaluser ALTER COLUMN normaluser_id SET DEFAULT nextval('normaluser_normaluser_id_seq'::regclass);


--
-- TOC entry 1924 (class 2604 OID 42879)
-- Name: player_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY player ALTER COLUMN player_id SET DEFAULT nextval('player_player_id_seq'::regclass);


--
-- TOC entry 2059 (class 0 OID 42823)
-- Dependencies: 173
-- Data for Name: administrator; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY administrator (administrator_id, administratortype, email, password) FROM stdin;
1	HEAD	kalo40@abv.bg	fdsafdsfsdf23f13
5	HEAD	kalo440@abv.bg	fdsafdsfsdf23f13
19	HEAD	admin@abv.bg	$shiro1$SHA-512$500000$$1nuc5NjQEqQIWzVAqoRMaQDmuQHAM8lSM0oWCqHoMh8eCIRgTh45qlgxxPOJ2pamDSkjnCxSJmUJ9osAobu9XA==
45	HEAD	adminaaa@abv.bg	$shiro1$SHA-512$500000$$1nuc5NjQEqQIWzVAqoRMaQDmuQHAM8lSM0oWCqHoMh8eCIRgTh45qlgxxPOJ2pamDSkjnCxSJmUJ9osAobu9XA==
46	NORMAL	a@a.b	$shiro1$SHA-512$500000$$MpXfx/LXm0Hp7tM4uaJXhJXT/hPB70GR3TU/1jfM5GefJAIcQ9NbOH7MenYHPoKro3wIHvkXmRTUz19u0NGeFQ==
47	HEAD	admi122n1@abv.bg	$shiro1$SHA-512$500000$$VJP4HiHKpTU4QuKuTJH/cxmLaJuaqfi4HsbLxPHfe4i/y+p0FxRa3b2iHV/CUsBJ+SUw4tizrfnfMYz8d+b3kQ==
53	HEAD	admi12a2n1@abv.bg	$shiro1$SHA-512$500000$$VJP4HiHKpTU4QuKuTJH/cxmLaJuaqfi4HsbLxPHfe4i/y+p0FxRa3b2iHV/CUsBJ+SUw4tizrfnfMYz8d+b3kQ==
56	HEAD	admi12aa2n1@abv.bg	$shiro1$SHA-512$500000$$VJP4HiHKpTU4QuKuTJH/cxmLaJuaqfi4HsbLxPHfe4i/y+p0FxRa3b2iHV/CUsBJ+SUw4tizrfnfMYz8d+b3kQ==
59	HEAD	aadmi12aa2n1@abv.bg	$shiro1$SHA-512$500000$$fHUo1njNDMhmYSKeO1HVtxNRWnutWgiI+pYQK1z4Xt/7jhS+5GAH4ysEKsS8WcE+zKllDXsGh9x9KgFs+9Kdvw==
60	HEAD	aaaaadmi12aa2n1@abv.bg	$shiro1$SHA-512$500000$$OzDzufZEt5ImiDhEbqQHaDhBgxrPFhqGXRk+mss0NYvSDefTWP08DYF+DuZUEFs0KlJhAqVZDpMCl04RRuxB8w==
61	HEAD	admin3@abv.bg	$shiro1$SHA-256$500000$DwgFbN93UHP5kc9Lrnp2rA==$mdgetxeufMz9zsGOA8O6i598VPItbFY/1wlR6AQZ2GY=
62	HEAD	admin33@abv.bg	$shiro1$SHA-256$500000$Rt/9uwB2swfZZN62+aG4qg==$KAHrSUuKYlFKRPMw8vcESJDYj8dIASfFHl6auaZFd+s=
63	HEAD	admin343@abv.bg	somepassowrd
64	HEAD	admin9@abv.bg	somepassowrd
65	HEAD	admin6@abv.bg	$shiro1$SHA-512$500000$$1nuc5NjQEqQIWzVAqoRMaQDmuQHAM8lSM0oWCqHoMh8eCIRgTh45qlgxxPOJ2pamDSkjnCxSJmUJ9osAobu9XA==
\.


--
-- TOC entry 2085 (class 0 OID 0)
-- Dependencies: 172
-- Name: administrator_administrator_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('administrator_administrator_id_seq', 65, true);


--
-- TOC entry 2061 (class 0 OID 42836)
-- Dependencies: 175
-- Data for Name: feedback; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY feedback (feedback_id, content, feedbackstatus, feedbacktype, normaluser_id) FROM stdin;
3	Improve game	ACTIVE	SUGGESTION	1
2	The rating scale for Performance Planning and Review is made up of five factors: Poor, Needs Improvement, Meets Requirements, Exceeds Requirements, and Outstanding. Any factor rated poor or needs improvement MUST have performance comments. For any factor, performancecomments should support the rating given. if there have been counseling sessions, letters of commendation or reprimand, or unofficialperformancereviews within the rating period, the supervisor should keep documentation on file and site these occurrences in theperformancecomments on the official rating. Below are examples of comments that would support individual ratings. These are generic in nature and examples only. Performance comments should be tailored to the individual employee and be based on the employee's individual performance expectations.	ACTIVE	PROBLEM	1
4	fdsafsa	ACTIVE	SUGGESTION	1
5	Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.	CLOSED	SUGGESTION	1
1	The rating scale for Performance Planning and Review is made up of five factors: Poor, Needs Improvement, Meets Requirements, Exceeds Requirements, and Outstanding. Any factor rated poor or needs improvement MUST have performance comments. For any factor, performance comments should support the rating given. if there have been counseling sessions, letters of commendation or reprimand, or unofficial performance reviews within the rating period, the supervisor should keep documentation on file and site these occurrences in the performance comments on the official rating. Below are examples of comments that would support individual ratings. These are generic in nature and examples only. Performance comments should be tailored to the individual employee and be based on the employee's individual performance expectations.	CLOSED	PROBLEM	1
6	It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).	ACTIVE	PROBLEM	11
7	It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).	ACTIVE	PROBLEM	11
\.


--
-- TOC entry 2086 (class 0 OID 0)
-- Dependencies: 174
-- Name: feedback_feedback_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('feedback_feedback_id_seq', 7, true);


--
-- TOC entry 2063 (class 0 OID 42844)
-- Dependencies: 177
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY item (item_id, level, type, player_id) FROM stdin;
1	2	Magnet	1
2	5	Jetpack	1
3	1	fsdafs	1
4	5	Jetpack	2
5	2	Magnet	2
6	1	fsdafs	2
7	5	Jetpack	3
8	1	fsdafs	3
9	2	Magnet	3
10	5	Jetpack	4
11	1	fsdafs	4
12	2	Magnet	4
28	1	ScoreMultiplier	11
29	5	Jetpack	11
30	2	Magnet	11
31	2	Magnet	12
32	1	fsdafs	12
33	5	Jetpack	12
34	5	Jetpack	13
35	1	Multiplier	13
36	2	Magnet	13
\.


--
-- TOC entry 2087 (class 0 OID 0)
-- Dependencies: 176
-- Name: item_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('item_item_id_seq', 36, true);


--
-- TOC entry 2065 (class 0 OID 42852)
-- Dependencies: 179
-- Data for Name: news; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY news (news_id, content, image, title, administrator_id) FROM stdin;
9	sed. Sed commodo lectus eget nisi malesuada maximus. Sed urna libero, pretium a erat id, tincidunt iaculis justo. Praesent sit amet massa quis erat convallis pellentesque sit amet at elit. Aliquam et nunc eget nunc convallis tincidunt.	http://www.lichdom-battlemage.com/wp-content/uploads/2016/01/Video-Game-Stories-3-1-21.jpg	Second Title	19
5	Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?	http://lilygirls.org/blog/wp-content/uploads/2015/06/Screenshot-2015-06-16-13.35.03-700x300.png	Some testing title	1
\.


--
-- TOC entry 2088 (class 0 OID 0)
-- Dependencies: 178
-- Name: news_news_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('news_news_id_seq', 24, true);


--
-- TOC entry 2067 (class 0 OID 42863)
-- Dependencies: 181
-- Data for Name: normaluser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY normaluser (normaluser_id, player_id) FROM stdin;
1	1
2	2
3	3
4	4
10	11
11	12
12	13
\.


--
-- TOC entry 2068 (class 0 OID 42871)
-- Dependencies: 182
-- Data for Name: normaluser_normaluser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY normaluser_normaluser (user0, friend) FROM stdin;
\.


--
-- TOC entry 2089 (class 0 OID 0)
-- Dependencies: 180
-- Name: normaluser_normaluser_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('normaluser_normaluser_id_seq', 12, true);


--
-- TOC entry 2070 (class 0 OID 42876)
-- Dependencies: 184
-- Data for Name: player; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY player (player_id, email, name, score) FROM stdin;
1	kalo1510@abv.bg	Kalin Marinov	1999
2	kalo11510@abv.bg	Kalin Marinov	149
3	kalo115140@abv.bg	Kalin Marinov	144449
4	k440@abv.bg	Kalin Marinov	119
11	fas1@abv.bg	Kalin Ivanov	211191
12	k4411110@abv.bg	Zed Ybieca	119
13	somevalidemail@abv.bg	Xin Zhao	119
\.


--
-- TOC entry 2090 (class 0 OID 0)
-- Dependencies: 183
-- Name: player_player_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('player_player_id_seq', 13, true);


--
-- TOC entry 1926 (class 2606 OID 42831)
-- Name: administrator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY administrator
    ADD CONSTRAINT administrator_pkey PRIMARY KEY (administrator_id);


--
-- TOC entry 1930 (class 2606 OID 42841)
-- Name: feedback_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (feedback_id);


--
-- TOC entry 1932 (class 2606 OID 42849)
-- Name: item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY item
    ADD CONSTRAINT item_pkey PRIMARY KEY (item_id);


--
-- TOC entry 1934 (class 2606 OID 42860)
-- Name: news_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY news
    ADD CONSTRAINT news_pkey PRIMARY KEY (news_id);


--
-- TOC entry 1936 (class 2606 OID 42868)
-- Name: normaluser_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY normaluser
    ADD CONSTRAINT normaluser_pkey PRIMARY KEY (normaluser_id);


--
-- TOC entry 1940 (class 2606 OID 42884)
-- Name: player_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY player
    ADD CONSTRAINT player_pkey PRIMARY KEY (player_id);


--
-- TOC entry 1928 (class 2606 OID 42833)
-- Name: u_dmnsrtr_email; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY administrator
    ADD CONSTRAINT u_dmnsrtr_email UNIQUE (email);


--
-- TOC entry 1938 (class 2606 OID 42870)
-- Name: u_nrmlusr_player_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY normaluser
    ADD CONSTRAINT u_nrmlusr_player_id UNIQUE (player_id);


--
-- TOC entry 1942 (class 2606 OID 42886)
-- Name: u_player_email; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY player
    ADD CONSTRAINT u_player_email UNIQUE (email);


--
-- TOC entry 1943 (class 2606 OID 175099)
-- Name: feedback_normaluser_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT feedback_normaluser_id_fkey FOREIGN KEY (normaluser_id) REFERENCES normaluser(normaluser_id) DEFERRABLE;


--
-- TOC entry 1944 (class 2606 OID 175104)
-- Name: item_player_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item
    ADD CONSTRAINT item_player_id_fkey FOREIGN KEY (player_id) REFERENCES player(player_id) DEFERRABLE;


--
-- TOC entry 1945 (class 2606 OID 175109)
-- Name: news_administrator_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY news
    ADD CONSTRAINT news_administrator_id_fkey FOREIGN KEY (administrator_id) REFERENCES administrator(administrator_id) DEFERRABLE;


--
-- TOC entry 1948 (class 2606 OID 175124)
-- Name: normaluser_normaluser_friend_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY normaluser_normaluser
    ADD CONSTRAINT normaluser_normaluser_friend_fkey FOREIGN KEY (friend) REFERENCES normaluser(normaluser_id) DEFERRABLE;


--
-- TOC entry 1947 (class 2606 OID 175119)
-- Name: normaluser_normaluser_user0_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY normaluser_normaluser
    ADD CONSTRAINT normaluser_normaluser_user0_fkey FOREIGN KEY (user0) REFERENCES normaluser(normaluser_id) DEFERRABLE;


--
-- TOC entry 1946 (class 2606 OID 175114)
-- Name: normaluser_player_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY normaluser
    ADD CONSTRAINT normaluser_player_id_fkey FOREIGN KEY (player_id) REFERENCES player(player_id) DEFERRABLE;


--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-25 20:11:55

--
-- PostgreSQL database dump complete
--

