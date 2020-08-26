--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-08-23 15:43:12 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 167327)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    contenu text,
    date timestamp without time zone,
    titre character varying(255),
    id_site integer,
    id_utilisateur integer
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 167325)
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- TOC entry 3221 (class 0 OID 0)
-- Dependencies: 202
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- TOC entry 205 (class 1259 OID 167338)
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    id integer NOT NULL,
    message character varying(255),
    status boolean,
    destinataire integer,
    emetteur integer,
    id_topo integer
);


ALTER TABLE public.message OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 167336)
-- Name: message_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.message_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.message_id_seq OWNER TO postgres;

--
-- TOC entry 3222 (class 0 OID 0)
-- Dependencies: 204
-- Name: message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.message_id_seq OWNED BY public.message.id;


--
-- TOC entry 207 (class 1259 OID 167346)
-- Name: photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.photo (
    id integer NOT NULL,
    chemin character varying(255),
    nom character varying(255),
    id_site integer
);


ALTER TABLE public.photo OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 167344)
-- Name: photo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.photo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.photo_id_seq OWNER TO postgres;

--
-- TOC entry 3223 (class 0 OID 0)
-- Dependencies: 206
-- Name: photo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.photo_id_seq OWNED BY public.photo.id;


--
-- TOC entry 209 (class 1259 OID 167357)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id integer NOT NULL,
    numero integer
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 167355)
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_id_seq OWNER TO postgres;

--
-- TOC entry 3224 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;


--
-- TOC entry 211 (class 1259 OID 167365)
-- Name: site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.site (
    id integer NOT NULL,
    cotation character varying(255),
    description text,
    hauteur character varying(255),
    id_longueurs character varying(255),
    nom character varying(255),
    officiel boolean,
    orientation character varying(255),
    pays character varying(255),
    region character varying(255),
    id_secteurs character varying(255),
    id_voies character varying(255)
);


ALTER TABLE public.site OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 167363)
-- Name: site_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.site_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.site_id_seq OWNER TO postgres;

--
-- TOC entry 3225 (class 0 OID 0)
-- Dependencies: 210
-- Name: site_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.site_id_seq OWNED BY public.site.id;


--
-- TOC entry 213 (class 1259 OID 167376)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    dateparution timestamp without time zone,
    description text,
    disponible boolean,
    lieu character varying(255),
    nom character varying(255),
    id_site integer,
    id_utilisateur integer
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 167374)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_id_seq OWNER TO postgres;

--
-- TOC entry 3226 (class 0 OID 0)
-- Dependencies: 212
-- Name: topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;


--
-- TOC entry 215 (class 1259 OID 167387)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id integer NOT NULL,
    adresse character varying(255),
    dateinscription timestamp without time zone,
    email character varying(255),
    membre boolean,
    motdepasse character varying(255),
    nom character varying(255),
    prenom character varying(255),
    telephone character varying(255)
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 167385)
-- Name: utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_seq OWNER TO postgres;

--
-- TOC entry 3227 (class 0 OID 0)
-- Dependencies: 214
-- Name: utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;


--
-- TOC entry 3047 (class 2604 OID 167330)
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- TOC entry 3048 (class 2604 OID 167341)
-- Name: message id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message ALTER COLUMN id SET DEFAULT nextval('public.message_id_seq'::regclass);


--
-- TOC entry 3049 (class 2604 OID 167349)
-- Name: photo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo ALTER COLUMN id SET DEFAULT nextval('public.photo_id_seq'::regclass);


--
-- TOC entry 3050 (class 2604 OID 167360)
-- Name: reservation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN id SET DEFAULT nextval('public.reservation_id_seq'::regclass);


--
-- TOC entry 3051 (class 2604 OID 167368)
-- Name: site id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site ALTER COLUMN id SET DEFAULT nextval('public.site_id_seq'::regclass);


--
-- TOC entry 3052 (class 2604 OID 167379)
-- Name: topo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id SET DEFAULT nextval('public.topo_id_seq'::regclass);


--
-- TOC entry 3053 (class 2604 OID 167390)
-- Name: utilisateur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id SET DEFAULT nextval('public.utilisateur_id_seq'::regclass);


--
-- TOC entry 3203 (class 0 OID 167327)
-- Dependencies: 203
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, contenu, date, titre, id_site, id_utilisateur) FROM stdin;
\.


--
-- TOC entry 3205 (class 0 OID 167338)
-- Dependencies: 205
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.message (id, message, status, destinataire, emetteur, id_topo) FROM stdin;
\.


--
-- TOC entry 3207 (class 0 OID 167346)
-- Dependencies: 207
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.photo (id, chemin, nom, id_site) FROM stdin;
\.


--
-- TOC entry 3209 (class 0 OID 167357)
-- Dependencies: 209
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id, numero) FROM stdin;
\.


--
-- TOC entry 3211 (class 0 OID 167365)
-- Dependencies: 211
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.site (id, cotation, description, hauteur, id_longueurs, nom, officiel, orientation, pays, region, id_secteurs, id_voies) FROM stdin;
\.


--
-- TOC entry 3213 (class 0 OID 167376)
-- Dependencies: 213
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, dateparution, description, disponible, lieu, nom, id_site, id_utilisateur) FROM stdin;
\.


--
-- TOC entry 3215 (class 0 OID 167387)
-- Dependencies: 215
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id, adresse, dateinscription, email, membre, motdepasse, nom, prenom, telephone) FROM stdin;
\.


--
-- TOC entry 3228 (class 0 OID 0)
-- Dependencies: 202
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 1, false);


--
-- TOC entry 3229 (class 0 OID 0)
-- Dependencies: 204
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.message_id_seq', 1, false);


--
-- TOC entry 3230 (class 0 OID 0)
-- Dependencies: 206
-- Name: photo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.photo_id_seq', 1, false);


--
-- TOC entry 3231 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 1, false);


--
-- TOC entry 3232 (class 0 OID 0)
-- Dependencies: 210
-- Name: site_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_id_seq', 1, false);


--
-- TOC entry 3233 (class 0 OID 0)
-- Dependencies: 212
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_id_seq', 1, false);


--
-- TOC entry 3234 (class 0 OID 0)
-- Dependencies: 214
-- Name: utilisateur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 1, false);


--
-- TOC entry 3055 (class 2606 OID 167335)
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- TOC entry 3057 (class 2606 OID 167343)
-- Name: message message_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id);


--
-- TOC entry 3059 (class 2606 OID 167354)
-- Name: photo photo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pkey PRIMARY KEY (id);


--
-- TOC entry 3061 (class 2606 OID 167362)
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);


--
-- TOC entry 3063 (class 2606 OID 167373)
-- Name: site site_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pkey PRIMARY KEY (id);


--
-- TOC entry 3065 (class 2606 OID 167384)
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id);


--
-- TOC entry 3067 (class 2606 OID 167395)
-- Name: utilisateur utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (id);


--
-- TOC entry 3073 (class 2606 OID 167421)
-- Name: photo fk29sluydh1r027rvrg4f9deiko; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT fk29sluydh1r027rvrg4f9deiko FOREIGN KEY (id_site) REFERENCES public.site(id);


--
-- TOC entry 3069 (class 2606 OID 167401)
-- Name: commentaire fk8mhbwnv33ivn50k7da2fb4igf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fk8mhbwnv33ivn50k7da2fb4igf FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 3075 (class 2606 OID 167431)
-- Name: topo fk9vfd37htlh7tec8f1nk3vtycr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fk9vfd37htlh7tec8f1nk3vtycr FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 3070 (class 2606 OID 167406)
-- Name: message fkimvui166ogvkv5gvi3if23pjw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT fkimvui166ogvkv5gvi3if23pjw FOREIGN KEY (destinataire) REFERENCES public.utilisateur(id);


--
-- TOC entry 3068 (class 2606 OID 167396)
-- Name: commentaire fkldyrhaptlavh11m58tcqfysbw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fkldyrhaptlavh11m58tcqfysbw FOREIGN KEY (id_site) REFERENCES public.site(id);


--
-- TOC entry 3072 (class 2606 OID 167416)
-- Name: message fksfdevdh78hx0jgt0t5yvk016i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT fksfdevdh78hx0jgt0t5yvk016i FOREIGN KEY (id_topo) REFERENCES public.topo(id);


--
-- TOC entry 3071 (class 2606 OID 167411)
-- Name: message fksqqvtp4n1wv4vgh29cq9flc5o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT fksqqvtp4n1wv4vgh29cq9flc5o FOREIGN KEY (emetteur) REFERENCES public.utilisateur(id);


--
-- TOC entry 3074 (class 2606 OID 167426)
-- Name: topo fkv3ivbw4x1m60hfsw0v1h1gfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fkv3ivbw4x1m60hfsw0v1h1gfk FOREIGN KEY (id_site) REFERENCES public.site(id);


-- Completed on 2020-08-23 15:43:18 CEST

--
-- PostgreSQL database dump complete
--

