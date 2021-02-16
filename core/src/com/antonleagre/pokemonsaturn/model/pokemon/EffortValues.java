package com.antonleagre.pokemonsaturn.model.pokemon;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * Effort Values are values that Pokemon get after each Battle in which they gain EXP (so no Battle Tower or lvl 100 pkmn).
 * There's a limit of 255 EV's per stat, 510 EV's total.
 * After a battle, 1, 2 or 3 EV's are given out to a particular stat, depending on the species
 * <p>
 * There are also items that influence EV, those will be implemented later
 * <p>
 */
public class EffortValues {

    private int hpEV;
    private int attackEV;
    private int defenseEV;
    private int specialAttackEV;
    private int specialDefenseEV;
    private int speedEV;

    public enum EVYieldByPokemonDefeated {
        BULBASAUR(64, 0, 0, 0, 1, 0, 0),
        IVYSAUR(141, 0, 0, 0, 1, 1, 0),
        VENUSAUR(208, 0, 0, 0, 2, 1, 0),
        CHARMANDER(65, 0, 0, 0, 0, 0, 1),
        CHARMELEON(142, 0, 0, 0, 1, 0, 1),
        CHARIZARD(209, 0, 0, 0, 3, 0, 0),
        SQUIRTLE(66, 0, 0, 1, 0, 0, 0),
        WARTORTLE(143, 0, 0, 1, 0, 1, 0),
        BLASTOISE(210, 0, 0, 0, 0, 3, 0),
        CATERPIE(53, 1, 0, 0, 0, 0, 0),
        METAPOD(72, 0, 0, 2, 0, 0, 0),
        BUTTERFREE(160, 0, 0, 0, 2, 1, 0),
        WEEDLE(52, 0, 0, 0, 0, 0, 1),
        KAKUNA(71, 0, 0, 2, 0, 0, 0),
        BEEDRILL(159, 0, 2, 0, 0, 1, 0),
        PIDGEY(55, 0, 0, 0, 0, 0, 1),
        PIDGEOTTO(113, 0, 0, 0, 0, 0, 2),
        PIDGEOT(172, 0, 0, 0, 0, 0, 3),
        RATTATA(57, 0, 0, 0, 0, 0, 1),
        RATICATE(116, 0, 0, 0, 0, 0, 2),
        SPEAROW(58, 0, 0, 0, 0, 0, 1),
        FEAROW(162, 0, 0, 0, 0, 0, 2),
        EKANS(62, 0, 1, 0, 0, 0, 0),
        ARBOK(147, 0, 2, 0, 0, 0, 0),
        PIKACHU(82, 0, 0, 0, 0, 0, 2),
        RAICHU(122, 0, 0, 0, 0, 0, 3),
        SANDSHREW(93, 0, 0, 1, 0, 0, 0),
        SANDSLASH(163, 0, 0, 2, 0, 0, 0),
        NIDORAN_F(59, 1, 0, 0, 0, 0, 0),
        NIDORINA(117, 2, 0, 0, 0, 0, 0),
        NIDOQUEEN(194, 3, 0, 0, 0, 0, 0),
        NIDORAN_M(60, 0, 1, 0, 0, 0, 0),
        NIDORINO(118, 0, 2, 0, 0, 0, 0),
        NIDOKING(195, 0, 3, 0, 0, 0, 0),
        CLEFAIRY(68, 2, 0, 0, 0, 0, 0),
        CLEFABLE(129, 3, 0, 0, 0, 0, 0),
        VULPIX(63, 0, 0, 0, 0, 0, 1),
        NINETALES(178, 0, 0, 0, 1, 1, 0),
        JIGGLYPUFF(76, 2, 0, 0, 0, 0, 0),
        WIGGLYTUFF(109, 3, 0, 0, 0, 0, 0),
        ZUBAT(54, 0, 0, 0, 0, 0, 1),
        GOLBAT(171, 0, 0, 0, 0, 0, 2),
        ODDISH(78, 0, 0, 0, 1, 0, 0),
        GLOOM(132, 0, 0, 0, 2, 0, 0),
        VILEPLUME(184, 0, 0, 0, 3, 0, 0),
        PARAS(70, 0, 1, 0, 0, 0, 0),
        PARASECT(128, 0, 2, 1, 0, 0, 0),
        VENONAT(75, 0, 0, 0, 0, 1, 0),
        VENOMOTH(138, 0, 0, 0, 1, 0, 1),
        DIGLETT(81, 0, 0, 0, 0, 0, 1),
        DUGTRIO(153, 0, 0, 0, 0, 0, 2),
        MEOWTH(69, 0, 0, 0, 0, 0, 1),
        PERSIAN(148, 0, 0, 0, 0, 0, 2),
        PSYDUCK(80, 0, 0, 0, 1, 0, 0),
        GOLDUCK(174, 0, 0, 0, 2, 0, 0),
        MANKEY(74, 0, 1, 0, 0, 0, 0),
        PRIMEAPE(149, 0, 2, 0, 0, 0, 0),
        GROWLITHE(91, 0, 1, 0, 0, 0, 0),
        ARCANINE(213, 0, 2, 0, 0, 0, 0),
        POLIWAG(77, 0, 0, 0, 0, 0, 1),
        POLIWHIRL(131, 0, 0, 0, 0, 0, 2),
        POLIWRATH(185, 0, 0, 3, 0, 0, 0),
        ABRA(75, 0, 0, 0, 1, 0, 0),
        KADABRA(145, 0, 0, 0, 2, 0, 0),
        ALAKAZAM(186, 0, 0, 0, 3, 0, 0),
        MACHOP(75, 0, 1, 0, 0, 0, 0),
        MACHOKE(146, 0, 2, 0, 0, 0, 0),
        MACHAMP(193, 0, 3, 0, 0, 0, 0),
        BELLSPROUT(84, 0, 1, 0, 0, 0, 0),
        WEEPINBELL(151, 0, 2, 0, 0, 0, 0),
        VICTREEBEL(191, 0, 3, 0, 0, 0, 0),
        TENTACOOL(105, 0, 0, 0, 0, 1, 0),
        TENTACRUEL(205, 0, 0, 0, 0, 2, 0),
        GEODUDE(73, 0, 0, 1, 0, 0, 0),
        GRAVELER(134, 0, 0, 2, 0, 0, 0),
        GOLEM(177, 0, 0, 3, 0, 0, 0),
        PONYTA(152, 0, 0, 0, 0, 0, 1),
        RAPIDASH(192, 0, 0, 0, 0, 0, 2),
        SLOWPOKE(99, 1, 0, 0, 0, 0, 0),
        SLOWBRO(164, 0, 0, 2, 0, 0, 0),
        MAGNEMITE(89, 0, 0, 0, 1, 0, 0),
        MAGNETON(161, 0, 0, 0, 2, 0, 0),
        FARFETCH_D(94, 0, 1, 0, 0, 0, 0),
        DODUO(96, 0, 1, 0, 0, 0, 0),
        DODRIO(158, 0, 2, 0, 0, 0, 0),
        SEEL(100, 0, 0, 0, 0, 1, 0),
        DEWGONG(176, 0, 0, 0, 0, 2, 0),
        GRIMER(90, 1, 0, 0, 0, 0, 0),
        MUK(157, 1, 1, 0, 0, 0, 0),
        SHELLDER(97, 0, 0, 1, 0, 0, 0),
        CLOYSTER(203, 0, 0, 2, 0, 0, 0),
        GASTLY(95, 0, 0, 0, 1, 0, 0),
        HAUNTER(126, 0, 0, 0, 2, 0, 0),
        GENGAR(190, 0, 0, 0, 3, 0, 0),
        ONIX(108, 0, 0, 1, 0, 0, 0),
        DROWZEE(102, 0, 0, 0, 0, 1, 0),
        HYPNO(165, 0, 0, 0, 0, 2, 0),
        KRABBY(115, 0, 1, 0, 0, 0, 0),
        KINGLER(206, 0, 2, 0, 0, 0, 0),
        VOLTORB(103, 0, 0, 0, 0, 0, 1),
        ELECTRODE(150, 0, 0, 0, 0, 0, 2),
        EXEGGCUTE(98, 0, 0, 1, 0, 0, 0),
        EXEGGUTOR(212, 0, 0, 0, 2, 0, 0),
        CUBONE(87, 0, 0, 1, 0, 0, 0),
        MAROWAK(124, 0, 0, 2, 0, 0, 0),
        HITMONLEE(139, 0, 2, 0, 0, 0, 0),
        HITMONCHAN(140, 0, 0, 0, 0, 2, 0),
        LICKITUNG(127, 2, 0, 0, 0, 0, 0),
        KOFFING(114, 0, 0, 1, 0, 0, 0),
        WEEZING(173, 0, 0, 2, 0, 0, 0),
        RHYHORN(135, 0, 0, 1, 0, 0, 0),
        RHYDON(204, 0, 2, 0, 0, 0, 0),
        CHANSEY(255, 2, 0, 0, 0, 0, 0),
        TANGELA(166, 0, 0, 1, 0, 0, 0),
        KANGASKHAN(175, 2, 0, 0, 0, 0, 0),
        HORSEA(83, 0, 0, 0, 1, 0, 0),
        SEADRA(155, 0, 0, 1, 1, 0, 0),
        GOLDEEN(111, 0, 1, 0, 0, 0, 0),
        SEAKING(170, 0, 2, 0, 0, 0, 0),
        STARYU(106, 0, 0, 0, 0, 0, 1),
        STARMIE(207, 0, 0, 0, 0, 0, 2),
        MR_MIME(136, 0, 0, 0, 0, 2, 0),
        SCYTHER(187, 0, 1, 0, 0, 0, 0),
        JYNX(137, 0, 0, 0, 2, 0, 0),
        ELECTABUZZ(156, 0, 0, 0, 0, 0, 2),
        MAGMAR(167, 0, 0, 0, 2, 0, 0),
        PINSIR(200, 0, 2, 0, 0, 0, 0),
        TAUROS(211, 0, 1, 0, 0, 0, 1),
        MAGIKARP(20, 0, 0, 0, 0, 0, 1),
        GYARADOS(214, 0, 2, 0, 0, 0, 0),
        LAPRAS(219, 2, 0, 0, 0, 0, 0),
        DITTO(61, 1, 0, 0, 0, 0, 0),
        EEVEE(92, 0, 0, 0, 0, 1, 0),
        VAPOREON(196, 2, 0, 0, 0, 0, 0),
        JOLTEON(197, 0, 0, 0, 0, 0, 2),
        FLAREON(198, 0, 2, 0, 0, 0, 0),
        PORYGON(130, 0, 0, 0, 1, 0, 0),
        OMANYTE(99, 0, 0, 1, 0, 0, 0),
        OMASTAR(199, 0, 0, 2, 0, 0, 0),
        KABUTO(99, 0, 0, 1, 0, 0, 0),
        KABUTOPS(199, 0, 2, 0, 0, 0, 0),
        AERODACTYL(202, 0, 0, 0, 0, 0, 2),
        SNORLAX(154, 2, 0, 0, 0, 0, 0),
        ARTICUNO(215, 0, 0, 0, 0, 3, 0),
        ZAPDOS(216, 0, 0, 0, 3, 0, 0),
        MOLTRES(217, 0, 0, 0, 3, 0, 0),
        DRATINI(67, 0, 1, 0, 0, 0, 0),
        DRAGONAIR(144, 0, 2, 0, 0, 0, 0),
        DRAGONITE(218, 0, 3, 0, 0, 0, 0),
        MEWTWO(220, 0, 0, 0, 3, 0, 0),
        MEW(64, 3, 0, 0, 0, 0, 0),
        CHIKORITA(64, 0, 0, 0, 0, 1, 0),
        BAYLEEF(141, 0, 0, 1, 0, 1, 0),
        MEGANIUM(208, 0, 0, 1, 0, 2, 0),
        CYNDAQUIL(65, 0, 0, 0, 0, 0, 1),
        QUILAVA(142, 0, 0, 0, 1, 0, 1),
        TYPHLOSION(209, 0, 0, 0, 3, 0, 0),
        TOTODILE(66, 0, 1, 0, 0, 0, 0),
        CROCONAW(143, 0, 1, 1, 0, 0, 0),
        FERALIGATR(210, 0, 2, 1, 0, 0, 0),
        SENTRET(57, 0, 1, 0, 0, 0, 0),
        FURRET(116, 0, 0, 0, 0, 0, 2),
        HOOTHOOT(58, 1, 0, 0, 0, 0, 0),
        NOCTOWL(162, 2, 0, 0, 0, 0, 0),
        LEDYBA(54, 0, 0, 0, 0, 1, 0),
        LEDIAN(134, 0, 0, 0, 0, 2, 0),
        SPINARAK(54, 0, 1, 0, 0, 0, 0),
        ARIADOS(134, 0, 2, 0, 0, 0, 0),
        CROBAT(204, 0, 0, 0, 0, 0, 3),
        CHINCHOU(90, 1, 0, 0, 0, 0, 0),
        LANTURN(156, 2, 0, 0, 0, 0, 0),
        PICHU(42, 0, 0, 0, 0, 0, 1),
        CLEFFA(37, 0, 0, 0, 0, 1, 0),
        IGGLYBUFF(39, 1, 0, 0, 0, 0, 0),
        TOGEPI(74, 0, 0, 0, 0, 1, 0),
        TOGETIC(114, 0, 0, 0, 0, 2, 0),
        NATU(73, 0, 0, 0, 1, 0, 0),
        XATU(171, 0, 0, 0, 1, 0, 1),
        MAREEP(59, 0, 0, 0, 1, 0, 0),
        FLAAFFY(117, 0, 0, 0, 2, 0, 0),
        AMPHAROS(194, 0, 0, 0, 3, 0, 0),
        BELLOSSOM(184, 0, 0, 0, 0, 3, 0),
        MARILL(58, 2, 0, 0, 0, 0, 0),
        AZUMARILL(153, 3, 0, 0, 0, 0, 0),
        SUDOWOODO(135, 0, 0, 2, 0, 0, 0),
        POLITOED(185, 0, 0, 0, 0, 3, 0),
        HOPPIP(74, 0, 0, 0, 0, 1, 0),
        SKIPLOOM(136, 0, 0, 0, 0, 0, 2),
        JUMPLUFF(176, 0, 0, 0, 0, 0, 3),
        AIPOM(94, 0, 0, 0, 0, 0, 1),
        SUNKERN(52, 0, 0, 0, 1, 0, 0),
        SUNFLORA(146, 0, 0, 0, 2, 0, 0),
        YANMA(147, 0, 0, 0, 0, 0, 1),
        WOOPER(52, 1, 0, 0, 0, 0, 0),
        QUAGSIRE(137, 2, 0, 0, 0, 0, 0),
        ESPEON(197, 0, 0, 0, 2, 0, 0),
        UMBREON(197, 0, 0, 0, 0, 2, 0),
        MURKROW(107, 0, 0, 0, 0, 0, 1),
        SLOWKING(164, 0, 0, 0, 0, 3, 0),
        MISDREAVUS(147, 0, 0, 0, 0, 1, 0),
        UNOWN(61, 0, 1, 0, 1, 0, 0),
        WOBBUFFET(177, 2, 0, 0, 0, 0, 0),
        GIRAFARIG(149, 0, 0, 0, 2, 0, 0),
        PINECO(60, 0, 0, 1, 0, 0, 0),
        FORRETRESS(118, 0, 0, 2, 0, 0, 0),
        DUNSPARCE(125, 1, 0, 0, 0, 0, 0),
        GLIGAR(108, 0, 0, 1, 0, 0, 0),
        STEELIX(196, 0, 0, 2, 0, 0, 0),
        SNUBBULL(63, 0, 1, 0, 0, 0, 0),
        GRANBULL(178, 0, 2, 0, 0, 0, 0),
        QWILFISH(100, 0, 1, 0, 0, 0, 0),
        SCIZOR(200, 0, 2, 0, 0, 0, 0),
        SHUCKLE(80, 0, 0, 1, 0, 1, 0),
        HERACROSS(200, 0, 2, 0, 0, 0, 0),
        SNEASEL(132, 0, 0, 0, 0, 0, 1),
        TEDDIURSA(124, 0, 1, 0, 0, 0, 0),
        URSARING(189, 0, 2, 0, 0, 0, 0),
        SLUGMA(78, 0, 0, 0, 1, 0, 0),
        MAGCARGO(154, 0, 0, 2, 0, 0, 0),
        SWINUB(78, 0, 1, 0, 0, 0, 0),
        PILOSWINE(160, 1, 1, 0, 0, 0, 0),
        CORSOLA(113, 0, 0, 1, 0, 1, 0),
        REMORAID(78, 0, 0, 0, 1, 0, 0),
        OCTILLERY(164, 0, 1, 0, 1, 0, 0),
        DELIBIRD(183, 0, 0, 0, 0, 0, 1),
        MANTINE(168, 0, 0, 0, 0, 2, 0),
        SKARMORY(168, 0, 0, 2, 0, 0, 0),
        HOUNDOUR(114, 0, 0, 0, 1, 0, 0),
        HOUNDOOM(204, 0, 0, 0, 2, 0, 0),
        KINGDRA(207, 0, 1, 0, 1, 1, 0),
        PHANPY(124, 1, 0, 0, 0, 0, 0),
        DONPHAN(189, 0, 1, 1, 0, 0, 0),
        PORYGON2(180, 0, 0, 0, 2, 0, 0),
        STANTLER(165, 0, 1, 0, 0, 0, 0),
        SMEARGLE(106, 0, 0, 0, 0, 0, 1),
        TYROGUE(91, 0, 1, 0, 0, 0, 0),
        HITMONTOP(138, 0, 0, 0, 0, 2, 0),
        SMOOCHUM(87, 0, 0, 0, 1, 0, 0),
        ELEKID(106, 0, 0, 0, 0, 0, 1),
        MAGBY(117, 0, 0, 0, 0, 0, 1),
        MILTANK(200, 0, 0, 2, 0, 0, 0),
        BLISSEY(255, 3, 0, 0, 0, 0, 0),
        RAIKOU(216, 0, 0, 0, 1, 0, 2),
        ENTEI(217, 1, 2, 0, 0, 0, 0),
        SUICUNE(215, 0, 0, 1, 0, 2, 0),
        LARVITAR(67, 0, 1, 0, 0, 0, 0),
        PUPITAR(144, 0, 2, 0, 0, 0, 0),
        TYRANITAR(218, 0, 3, 0, 0, 0, 0),
        LUGIA(220, 0, 0, 0, 0, 3, 0),
        HO_OH(220, 0, 0, 0, 0, 3, 0),
        CELEBI(64, 3, 0, 0, 0, 0, 0),
        TREECKO(65, 0, 0, 0, 0, 0, 1),
        GROVYLE(141, 0, 0, 0, 0, 0, 2),
        SCEPTILE(208, 0, 0, 0, 0, 0, 3),
        TORCHIC(65, 0, 0, 0, 1, 0, 0),
        COMBUSKEN(142, 0, 1, 0, 1, 0, 0),
        BLAZIKEN(209, 0, 3, 0, 0, 0, 0),
        MUDKIP(65, 0, 1, 0, 0, 0, 0),
        MARSHTOMP(143, 0, 2, 0, 0, 0, 0),
        SWAMPERT(210, 0, 3, 0, 0, 0, 0),
        POOCHYENA(55, 0, 1, 0, 0, 0, 0),
        MIGHTYENA(128, 0, 2, 0, 0, 0, 0),
        ZIGZAGOON(60, 0, 0, 0, 0, 0, 1),
        LINOONE(128, 0, 0, 0, 0, 0, 2),
        WURMPLE(54, 1, 0, 0, 0, 0, 0),
        SILCOON(72, 0, 0, 2, 0, 0, 0),
        BEAUTIFLY(161, 0, 0, 0, 3, 0, 0),
        CASCOON(72, 0, 0, 2, 0, 0, 0),
        DUSTOX(161, 0, 0, 0, 0, 3, 0),
        LOTAD(74, 0, 0, 0, 0, 1, 0),
        LOMBRE(141, 0, 0, 0, 0, 2, 0),
        LUDICOLO(181, 0, 0, 0, 0, 3, 0),
        SEEDOT(74, 0, 0, 1, 0, 0, 0),
        NUZLEAF(141, 0, 2, 0, 0, 0, 0),
        SHIFTRY(181, 0, 3, 0, 0, 0, 0),
        TAILLOW(59, 0, 0, 0, 0, 0, 1),
        SWELLOW(162, 0, 0, 0, 0, 0, 2),
        WINGULL(64, 0, 0, 0, 0, 0, 1),
        PELIPPER(164, 0, 0, 2, 0, 0, 0),
        RALTS(70, 0, 0, 0, 1, 0, 0),
        KIRLIA(140, 0, 0, 0, 2, 0, 0),
        GARDEVOIR(208, 0, 0, 0, 3, 0, 0),
        SURSKIT(63, 0, 0, 0, 0, 0, 1),
        MASQUERAIN(128, 0, 0, 0, 1, 1, 0),
        SHROOMISH(65, 1, 0, 0, 0, 0, 0),
        BRELOOM(165, 0, 2, 0, 0, 0, 0),
        SLAKOTH(83, 1, 0, 0, 0, 0, 0),
        VIGOROTH(126, 0, 0, 0, 0, 0, 2),
        SLAKING(210, 3, 0, 0, 0, 0, 0),
        NINCADA(65, 0, 0, 1, 0, 0, 0),
        NINJASK(155, 0, 0, 0, 0, 0, 2),
        SHEDINJA(95, 2, 0, 0, 0, 0, 0),
        WHISMUR(68, 1, 0, 0, 0, 0, 0),
        LOUDRED(126, 2, 0, 0, 0, 0, 0),
        EXPLOUD(184, 3, 0, 0, 0, 0, 0),
        MAKUHITA(87, 1, 0, 0, 0, 0, 0),
        HARIYAMA(184, 2, 0, 0, 0, 0, 0),
        AZURILL(33, 1, 0, 0, 0, 0, 0),
        NOSEPASS(108, 0, 0, 1, 0, 0, 0),
        SKITTY(65, 0, 0, 0, 0, 0, 1),
        DELCATTY(138, 1, 0, 0, 0, 0, 1),
        SABLEYE(98, 0, 1, 1, 0, 0, 0),
        MAWILE(98, 0, 1, 1, 0, 0, 0),
        ARON(96, 0, 0, 1, 0, 0, 0),
        LAIRON(152, 0, 0, 2, 0, 0, 0),
        AGGRON(205, 0, 0, 3, 0, 0, 0),
        MEDITITE(91, 0, 0, 0, 0, 0, 1),
        MEDICHAM(153, 0, 0, 0, 0, 0, 2),
        ELECTRIKE(104, 0, 0, 0, 0, 0, 1),
        MANECTRIC(168, 0, 0, 0, 0, 0, 2),
        PLUSLE(120, 0, 0, 0, 0, 0, 1),
        MINUN(120, 0, 0, 0, 0, 0, 1),
        VOLBEAT(146, 0, 0, 0, 0, 0, 1),
        ILLUMISE(146, 0, 0, 0, 0, 0, 1),
        ROSELIA(152, 0, 0, 0, 2, 0, 0),
        GULPIN(75, 1, 0, 0, 0, 0, 0),
        SWALOT(168, 2, 0, 0, 0, 0, 0),
        CARVANHA(88, 0, 1, 0, 0, 0, 0),
        SHARPEDO(175, 0, 2, 0, 0, 0, 0),
        WAILMER(137, 1, 0, 0, 0, 0, 0),
        WAILORD(206, 2, 0, 0, 0, 0, 0),
        NUMEL(88, 0, 0, 0, 1, 0, 0),
        CAMERUPT(175, 0, 1, 0, 1, 0, 0),
        TORKOAL(161, 0, 0, 2, 0, 0, 0),
        SPOINK(89, 0, 0, 0, 0, 1, 0),
        GRUMPIG(164, 0, 0, 0, 0, 2, 0),
        SPINDA(85, 0, 0, 0, 1, 0, 0),
        TRAPINCH(73, 0, 1, 0, 0, 0, 0),
        VIBRAVA(126, 0, 1, 0, 0, 0, 1),
        FLYGON(197, 0, 1, 0, 0, 0, 2),
        CACNEA(97, 0, 0, 0, 1, 0, 0),
        CACTURNE(177, 0, 1, 0, 1, 0, 0),
        SWABLU(74, 0, 0, 0, 0, 1, 0),
        ALTARIA(188, 0, 0, 0, 0, 2, 0),
        ZANGOOSE(165, 0, 2, 0, 0, 0, 0),
        SEVIPER(165, 0, 1, 0, 1, 0, 0),
        LUNATONE(150, 0, 0, 0, 2, 0, 0),
        SOLROCK(150, 0, 2, 0, 0, 0, 0),
        BARBOACH(92, 1, 0, 0, 0, 0, 0),
        WHISCASH(158, 2, 0, 0, 0, 0, 0),
        CORPHISH(111, 0, 1, 0, 0, 0, 0),
        CRAWDAUNT(161, 0, 2, 0, 0, 0, 0),
        BALTOY(58, 0, 0, 0, 0, 1, 0),
        CLAYDOL(189, 0, 0, 0, 0, 2, 0),
        LILEEP(99, 0, 0, 0, 0, 1, 0),
        CRADILY(199, 0, 0, 0, 0, 2, 0),
        ANORITH(99, 0, 1, 0, 0, 0, 0),
        ARMALDO(199, 0, 2, 0, 0, 0, 0),
        FEEBAS(61, 0, 0, 0, 0, 0, 1),
        MILOTIC(213, 0, 0, 0, 0, 2, 0),
        CASTFORM(145, 1, 0, 0, 0, 0, 0),
        KECLEON(132, 0, 0, 0, 0, 1, 0),
        SHUPPET(97, 0, 1, 0, 0, 0, 0),
        BANETTE(179, 0, 2, 0, 0, 0, 0),
        DUSKULL(97, 0, 0, 0, 0, 1, 0),
        DUSCLOPS(179, 0, 0, 1, 0, 1, 0),
        TROPIUS(169, 2, 0, 0, 0, 0, 0),
        CHIMECHO(147, 0, 0, 0, 1, 1, 0),
        ABSOL(174, 0, 2, 0, 0, 0, 0),
        WYNAUT(44, 1, 0, 0, 0, 0, 0),
        SNORUNT(74, 1, 0, 0, 0, 0, 0),
        GLALIE(187, 2, 0, 0, 0, 0, 0),
        SPHEAL(75, 1, 0, 0, 0, 0, 0),
        SEALEO(128, 2, 0, 0, 0, 0, 0),
        WALREIN(192, 3, 0, 0, 0, 0, 0),
        CLAMPERL(142, 0, 0, 1, 0, 0, 0),
        HUNTAIL(178, 0, 1, 1, 0, 0, 0),
        GOREBYSS(178, 0, 0, 0, 2, 0, 0),
        RELICANTH(198, 1, 0, 1, 0, 0, 0),
        LUVDISC(110, 0, 0, 0, 0, 0, 1),
        BAGON(89, 0, 1, 0, 0, 0, 0),
        SHELGON(144, 0, 0, 2, 0, 0, 0),
        SALAMENCE(218, 0, 3, 0, 0, 0, 0),
        BELDUM(103, 0, 0, 1, 0, 0, 0),
        METANG(153, 0, 0, 2, 0, 0, 0),
        METAGROSS(210, 0, 0, 3, 0, 0, 0),
        REGIROCK(217, 0, 0, 3, 0, 0, 0),
        REGICE(216, 0, 0, 0, 0, 3, 0),
        REGISTEEL(215, 0, 0, 2, 0, 1, 0),
        LATIAS(211, 0, 0, 0, 0, 3, 0),
        LATIOS(211, 0, 0, 0, 3, 0, 0),
        KYOGRE(218, 0, 0, 0, 3, 0, 0),
        GROUDON(218, 0, 3, 0, 0, 0, 0),
        RAYQUAZA(220, 0, 2, 0, 1, 0, 0),
        JIRACHI(215, 3, 0, 0, 0, 0, 0),
        DEOXYS(215, 0, 1, 0, 1, 0, 1),
        TURTWIG(215, 0, 2, 0, 1, 0, 0),
        GROTLE(215, 0, 0, 2, 0, 1, 0),
        TORTERRA(215, 0, 0, 0, 0, 0, 3),
        CHIMCHAR(64, 0, 1, 0, 0, 0, 0),
        MONFERNO(141, 0, 1, 1, 0, 0, 0),
        INFERNAPE(208, 0, 2, 1, 0, 0, 0),
        PIPLUP(65, 0, 0, 0, 0, 0, 1),
        PRINPLUP(142, 0, 0, 0, 1, 0, 1),
        EMPOLEON(209, 0, 1, 0, 1, 0, 1),
        STARLY(66, 0, 0, 0, 1, 0, 0),
        STARAVIA(143, 0, 0, 0, 2, 0, 0),
        STARAPTOR(210, 0, 0, 0, 3, 0, 0),
        BIDOOF(56, 0, 0, 0, 0, 0, 1),
        BIBAREL(113, 0, 0, 0, 0, 0, 2),
        KRICKETOT(172, 0, 3, 0, 0, 0, 0),
        KRICKETUNE(58, 1, 0, 0, 0, 0, 0),
        SHINX(116, 0, 2, 0, 0, 0, 0),
        LUXIO(54, 0, 0, 1, 0, 0, 0),
        LUXRAY(159, 0, 2, 0, 0, 0, 0),
        BUDEW(60, 0, 1, 0, 0, 0, 0),
        ROSERADE(117, 0, 2, 0, 0, 0, 0),
        CRANIDOS(194, 0, 3, 0, 0, 0, 0),
        RAMPARDOS(68, 0, 0, 0, 1, 0, 0),
        SHIELDON(204, 0, 0, 0, 3, 0, 0),
        BASTIODON(99, 0, 1, 0, 0, 0, 0),
        BURMY(199, 0, 2, 0, 0, 0, 0),
        WORMADAM(99, 0, 0, 1, 0, 0, 0),
        MOTHIM(199, 0, 0, 2, 0, 0, 0),
        COMBEE(61, 0, 0, 0, 0, 1, 0),
        VESPIQUEN(159, 0, 0, 0, 0, 2, 0),
        PACHIRISU(159, 0, 0, 2, 0, 0, 0),
        BUIZEL(159, 0, 0, 1, 0, 1, 0),
        FLOATZEL(159, 0, 1, 0, 1, 0, 0),
        CHERUBI(63, 0, 0, 0, 0, 0, 1),
        CHERRIM(188, 0, 0, 1, 0, 1, 0),
        SHELLOS(120, 0, 0, 0, 0, 0, 1),
        GASTRODON(75, 0, 0, 0, 0, 0, 1),
        AMBIPOM(178, 0, 0, 0, 0, 0, 2),
        DRIFLOON(68, 0, 0, 0, 1, 0, 0),
        DRIFBLIM(133, 0, 0, 0, 2, 0, 0),
        BUNEARY(73, 1, 0, 0, 0, 0, 0),
        LOPUNNY(176, 2, 0, 0, 0, 0, 0),
        MISMAGIUS(186, 0, 0, 0, 0, 0, 2),
        HONCHKROW(127, 1, 0, 0, 0, 0, 0),
        GLAMEOW(204, 2, 0, 0, 0, 0, 0),
        PURUGLY(84, 0, 0, 0, 0, 0, 1),
        CHINGLING(178, 0, 0, 0, 0, 0, 2),
        STUNKY(187, 0, 0, 0, 1, 1, 0),
        SKUNTANK(187, 0, 2, 0, 0, 0, 0),
        BRONZOR(71, 0, 0, 0, 0, 0, 1),
        BRONZONG(183, 0, 0, 0, 0, 0, 2),
        BONSLY(74, 0, 0, 0, 1, 0, 0),
        MIME_JR(79, 0, 0, 0, 0, 0, 1),
        HAPPINY(209, 2, 0, 0, 0, 0, 0),
        CHATOT(72, 0, 0, 1, 0, 0, 0),
        SPIRITOMB(188, 0, 0, 1, 0, 1, 0),
        GIBLE(68, 0, 0, 1, 0, 0, 0),
        GABITE(78, 0, 0, 0, 0, 1, 0),
        GARCHOMP(255, 1, 0, 0, 0, 0, 0),
        MUNCHLAX(107, 0, 1, 0, 0, 0, 0),
        RIOLU(168, 0, 0, 1, 0, 1, 0),
        LUCARIO(67, 0, 1, 0, 0, 0, 0),
        HIPPOPOTAS(144, 0, 2, 0, 0, 0, 0),
        HIPPOWDON(218, 0, 3, 0, 0, 0, 0),
        SKORUPI(94, 1, 0, 0, 0, 0, 0),
        DRAPION(72, 0, 1, 0, 0, 0, 0),
        CROAGUNK(204, 0, 1, 0, 1, 0, 0),
        TOXICROAK(95, 0, 0, 1, 0, 0, 0),
        CARNIVINE(198, 0, 0, 2, 0, 0, 0),
        FINNEON(114, 0, 0, 1, 0, 0, 0),
        LUMINEON(204, 0, 0, 2, 0, 0, 0),
        MANTYKE(83, 0, 1, 0, 0, 0, 0),
        SNOVER(181, 0, 2, 0, 0, 0, 0),
        ABOMASNOW(164, 0, 2, 0, 0, 0, 0),
        WEAVILE(90, 0, 0, 0, 0, 0, 1),
        MAGNEZONE(156, 0, 0, 0, 0, 0, 2),
        LICKILICKY(108, 0, 0, 0, 0, 1, 0),
        RHYPERIOR(131, 0, 1, 0, 0, 0, 0),
        TANGROWTH(214, 0, 1, 0, 1, 0, 0),
        ELECTIVIRE(199, 0, 1, 0, 0, 0, 1),
        MAGMORTAR(211, 0, 0, 0, 3, 0, 0),
        TOGEKISS(193, 3, 0, 0, 0, 0, 0),
        YANMEGA(217, 0, 3, 0, 0, 0, 0),
        LEAFEON(211, 0, 0, 2, 0, 0, 0),
        GLACEON(199, 0, 3, 0, 0, 0, 0),
        GLISCOR(199, 0, 0, 0, 3, 0, 0),
        MAMOSWINE(220, 0, 0, 0, 2, 1, 0),
        PORYGON_Z(198, 0, 2, 0, 0, 0, 0),
        GALLADE(196, 0, 0, 2, 0, 0, 0),
        PROBOPASS(196, 0, 0, 0, 2, 0, 0),
        DUSKNOIR(192, 0, 0, 2, 0, 0, 0),
        FROSLASS(207, 0, 3, 0, 0, 0, 0),
        ROTOM(185, 0, 0, 0, 3, 0, 0),
        UXIE(208, 0, 3, 0, 0, 0, 0),
        MESPRIT(198, 0, 0, 1, 0, 2, 0),
        AZELF(210, 0, 0, 1, 0, 2, 0),
        DIALGA(187, 0, 0, 0, 0, 0, 2),
        PALKIA(132, 0, 0, 0, 1, 0, 1),
        HEATRAN(210, 0, 0, 2, 0, 1, 0),
        REGIGIGAS(210, 0, 1, 0, 1, 1, 0),
        GIRATINA(210, 0, 2, 0, 1, 0, 0),
        CRESSELIA(220, 0, 0, 0, 3, 0, 0),
        PHIONE(220, 0, 0, 0, 3, 0, 0),
        MANAPHY(215, 0, 0, 0, 3, 0, 0),
        DARKRAI(220, 0, 3, 0, 0, 0, 0),
        SHAYMIN(220, 3, 0, 0, 0, 0, 0),
        ARCEUS(210, 0, 0, 0, 0, 3, 0);

        private final int totalExp;
        private final int hpEVYield;
        private final int attackEVYield;
        private final int defenseEVYield;
        private final int specialAttackEVYield;
        private final int specialDefenseEVYield;
        private final int speedEVYield;

        EVYieldByPokemonDefeated(int totalExp, int hpEVYield, int attackEVYield, int defenseEVYield,
                                 int specialAttackEVYield,
                                 int specialDefenseEVYield, int speedEVYield) {
            this.totalExp = totalExp;
            this.hpEVYield = hpEVYield;
            this.attackEVYield = attackEVYield;
            this.defenseEVYield = defenseEVYield;
            this.specialAttackEVYield = specialAttackEVYield;
            this.specialDefenseEVYield = specialDefenseEVYield;
            this.speedEVYield = speedEVYield;
        }
    }

    public int getHpEV() {
        return hpEV;
    }

    public int getAttackEV() {
        return attackEV;
    }

    public int getDefenseEV() {
        return defenseEV;
    }

    public int getSpecialAttackEV() {
        return specialAttackEV;
    }

    public int getSpecialDefenseEV() {
        return specialDefenseEV;
    }

    public int getSpeedEV() {
        return speedEV;
    }

    @Override
    public String toString() {
        return "HP: " + hpEV + "; Attack: " + attackEV + "; Defense: " + defenseEV + "\n" +
                "Special Attack: " + specialAttackEV + "; Special Defense: " + specialDefenseEV + "; Speed: " + speedEV;
    }

    public static EffortValues generateEffortValues() {
        return new EffortValues();
    }


    /**
     *
     * @param url I normally use this url:  https://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_effort_value_yield_(Generation_IV)
     * @return
     */
    public static EffortValues grabEVYieldByPokemon(String url) {
        try {
            Document parsed = Jsoup.connect(url).get();
            Element table = parsed.selectFirst("table.sortable");
            Elements pokemon = table.select("tr"); //rows
            for (int i = 251; i <= 493; i++) { // the first row is a header, the 250 number is the last national dex id
                // to be included
                Element poke = pokemon.get(i);
                BasePokemon basepoke = BasePokemon.values()[i - 1];
                Elements ds = poke.select("td");

                System.out.println(new StringBuilder().append(basepoke.name()).append("(").append(ds.get(3).text()).append(", ")
                        .append(ds.get(4).text()).append(", ").append(ds.get(5).text()).append(", ").append(ds.get(6).text())
                        .append(", ").append(ds.get(7).text()).append(", ").append(ds.get(8).text()).append(", ")
                        .append(ds.get(9).text()).append("),").toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        grabEVYieldByPokemon("https://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_effort_value_yield_(Generation_IV)");

    }


}
