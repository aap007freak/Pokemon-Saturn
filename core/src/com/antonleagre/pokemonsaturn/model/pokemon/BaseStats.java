package com.antonleagre.pokemonsaturn.model.pokemon;

/**
 * Base Stats of all Gen 1 - 2 Pokemon (until pokedex entry 250: HO_OH);
 *  Acts like a database of sorts, with some irregularities;
 *  -The fairy type is assumed to exist, which it doesnt until gen 6
 *  -there is not an f at the end of the speed base stat, sorry for that
 *  -some pokemon names have been altered to not generate compile errors (nidoran male or female for example);
 *
 *  Data taken (stolen) from: https://pokemondb.net/pokedex/
 */
public enum BaseStats {

    BULBASAUR(Type.GRASS, Type.POISON, 45f, 49f, 65f, 65f, 65f, 45),
    IVYSAUR(Type.GRASS, Type.POISON, 60f, 49f, 65f, 80f, 80f, 60),
    VENUSAUR(Type.GRASS, Type.POISON, 80f, 49f, 65f, 100f, 100f, 80),
    CHARMANDER(Type.FIRE, 39f, 49f, 65f, 60f, 50f, 65),
    CHARMELEON(Type.FIRE, 58f, 49f, 65f, 80f, 65f, 80),
    CHARIZARD(Type.FIRE, Type.FLYING, 78f, 49f, 65f, 109f, 85f, 100),
    SQUIRTLE(Type.WATER, 44f, 49f, 65f, 50f, 64f, 43),
    WARTORTLE(Type.WATER, 59f, 49f, 65f, 65f, 80f, 58),
    BLASTOISE(Type.WATER, 79f, 49f, 65f, 85f, 105f, 78),
    CATERPIE(Type.BUG, 45f, 49f, 65f, 20f, 20f, 45),
    METAPOD(Type.BUG, 50f, 49f, 65f, 25f, 25f, 30),
    BUTTERFREE(Type.BUG, Type.FLYING, 60f, 49f, 65f, 90f, 80f, 70),
    WEEDLE(Type.BUG, Type.POISON, 40f, 49f, 65f, 20f, 20f, 50),
    KAKUNA(Type.BUG, Type.POISON, 45f, 49f, 65f, 25f, 25f, 35),
    BEEDRILL(Type.BUG, Type.POISON, 65f, 49f, 65f, 45f, 80f, 75),
    PIDGEY(Type.NORMAL, Type.FLYING, 40f, 49f, 65f, 35f, 35f, 56),
    PIDGEOTTO(Type.NORMAL, Type.FLYING, 63f, 49f, 65f, 50f, 50f, 71),
    PIDGEOT(Type.NORMAL, Type.FLYING, 83f, 49f, 65f, 70f, 70f, 101),
    RATTATA(Type.NORMAL, 30f, 49f, 65f, 25f, 35f, 72),
    RATICATE(Type.NORMAL, 55f, 49f, 65f, 50f, 70f, 97),
    SPEAROW(Type.NORMAL, Type.FLYING, 40f, 49f, 65f, 31f, 31f, 70),
    FEAROW(Type.NORMAL, Type.FLYING, 65f, 49f, 65f, 61f, 61f, 100),
    EKANS(Type.POISON, 35f, 49f, 65f, 40f, 54f, 55),
    ARBOK(Type.POISON, 60f, 49f, 65f, 65f, 79f, 80),
    PIKACHU(Type.ELECTRIC, 35f, 49f, 65f, 50f, 50f, 90),
    RAICHU(Type.ELECTRIC, 60f, 49f, 65f, 90f, 80f, 110),
    SANDSHREW(Type.GROUND, 50f, 49f, 65f, 20f, 30f, 40),
    SANDSLASH(Type.GROUND, 75f, 49f, 65f, 45f, 55f, 65),
    NIDORAN_FEMALE(Type.POISON, 55f, 49f, 65f, 40f, 40f, 41),
    NIDORINA(Type.POISON, 70f, 49f, 65f, 55f, 55f, 56),
    NIDOQUEEN(Type.POISON, Type.GROUND, 90f, 49f, 65f, 75f, 85f, 76),
    NIDORAN_MALE(Type.POISON, 46f, 49f, 65f, 40f, 40f, 50),
    NIDORINO(Type.POISON, 61f, 49f, 65f, 55f, 55f, 65),
    NIDOKING(Type.POISON, Type.GROUND, 81f, 49f, 65f, 85f, 75f, 85),
    CLEFAIRY(Type.FAIRY, 70f, 49f, 65f, 60f, 65f, 35),
    CLEFABLE(Type.FAIRY, 95f, 49f, 65f, 95f, 90f, 60),
    VULPIX(Type.FIRE, 38f, 49f, 65f, 50f, 65f, 65),
    NINETALES(Type.FIRE, 73f, 49f, 65f, 81f, 100f, 100),
    JIGGLYPUFF(Type.NORMAL, Type.FAIRY, 115f, 49f, 65f, 45f, 25f, 20),
    WIGGLYTUFF(Type.NORMAL, Type.FAIRY, 140f, 49f, 65f, 85f, 50f, 45),
    ZUBAT(Type.POISON, Type.FLYING, 40f, 49f, 65f, 30f, 40f, 55),
    GOLBAT(Type.POISON, Type.FLYING, 75f, 49f, 65f, 65f, 75f, 90),
    ODDISH(Type.GRASS, Type.POISON, 45f, 49f, 65f, 75f, 65f, 30),
    GLOOM(Type.GRASS, Type.POISON, 60f, 49f, 65f, 85f, 75f, 40),
    VILEPLUME(Type.GRASS, Type.POISON, 75f, 49f, 65f, 110f, 90f, 50),
    PARAS(Type.BUG, Type.GRASS, 35f, 49f, 65f, 45f, 55f, 25),
    PARASECT(Type.BUG, Type.GRASS, 60f, 49f, 65f, 60f, 80f, 30),
    VENONAT(Type.BUG, Type.POISON, 60f, 49f, 65f, 40f, 55f, 45),
    VENOMOTH(Type.BUG, Type.POISON, 70f, 49f, 65f, 90f, 75f, 90),
    DIGLETT(Type.GROUND, 10f, 49f, 65f, 35f, 45f, 95),
    DUGTRIO(Type.GROUND, 35f, 49f, 65f, 50f, 70f, 120),
    MEOWTH(Type.NORMAL, 40f, 49f, 65f, 40f, 40f, 90),
    PERSIAN(Type.NORMAL, 65f, 49f, 65f, 65f, 65f, 115),
    PSYDUCK(Type.WATER, 50f, 49f, 65f, 65f, 50f, 55),
    GOLDUCK(Type.WATER, 80f, 49f, 65f, 95f, 80f, 85),
    MANKEY(Type.FIGHTING, 40f, 49f, 65f, 35f, 45f, 70),
    PRIMEAPE(Type.FIGHTING, 65f, 49f, 65f, 60f, 70f, 95),
    GROWLITHE(Type.FIRE, 55f, 49f, 65f, 70f, 50f, 60),
    ARCANINE(Type.FIRE, 90f, 49f, 65f, 100f, 80f, 95),
    POLIWAG(Type.WATER, 40f, 49f, 65f, 40f, 40f, 90),
    POLIWHIRL(Type.WATER, 65f, 49f, 65f, 50f, 50f, 90),
    POLIWRATH(Type.WATER, Type.FIGHTING, 90f, 49f, 65f, 70f, 90f, 70),
    ABRA(Type.PSYCHIC, 25f, 49f, 65f, 105f, 55f, 90),
    KADABRA(Type.PSYCHIC, 40f, 49f, 65f, 120f, 70f, 105),
    ALAKAZAM(Type.PSYCHIC, 55f, 49f, 65f, 135f, 95f, 120),
    MACHOP(Type.FIGHTING, 70f, 49f, 65f, 35f, 35f, 35),
    MACHOKE(Type.FIGHTING, 80f, 49f, 65f, 50f, 60f, 45),
    MACHAMP(Type.FIGHTING, 90f, 49f, 65f, 65f, 85f, 55),
    BELLSPROUT(Type.GRASS, Type.POISON, 50f, 49f, 65f, 70f, 30f, 40),
    WEEPINBELL(Type.GRASS, Type.POISON, 65f, 49f, 65f, 85f, 45f, 55),
    VICTREEBEL(Type.GRASS, Type.POISON, 80f, 49f, 65f, 100f, 70f, 70),
    TENTACOOL(Type.WATER, Type.POISON, 40f, 49f, 65f, 50f, 100f, 70),
    TENTACRUEL(Type.WATER, Type.POISON, 80f, 49f, 65f, 80f, 120f, 100),
    GEODUDE(Type.ROCK, Type.GROUND, 40f, 49f, 65f, 30f, 30f, 20),
    GRAVELER(Type.ROCK, Type.GROUND, 55f, 49f, 65f, 45f, 45f, 35),
    GOLEM(Type.ROCK, Type.GROUND, 80f, 49f, 65f, 55f, 65f, 45),
    PONYTA(Type.FIRE, 50f, 49f, 65f, 65f, 65f, 90),
    RAPIDASH(Type.FIRE, 65f, 49f, 65f, 80f, 80f, 105),
    SLOWPOKE(Type.WATER, Type.PSYCHIC, 90f, 49f, 65f, 40f, 40f, 15),
    SLOWBRO(Type.WATER, Type.PSYCHIC, 95f, 49f, 65f, 100f, 80f, 30),
    MAGNEMITE(Type.ELECTRIC, Type.STEEL, 25f, 49f, 65f, 95f, 55f, 45),
    MAGNETON(Type.ELECTRIC, Type.STEEL, 50f, 49f, 65f, 120f, 70f, 70),
    FARFETCH_D(Type.NORMAL, Type.FLYING, 52f, 49f, 65f, 58f, 62f, 60),
    DODUO(Type.NORMAL, Type.FLYING, 35f, 49f, 65f, 35f, 35f, 75),
    DODRIO(Type.NORMAL, Type.FLYING, 60f, 49f, 65f, 60f, 60f, 110),
    SEEL(Type.WATER, 65f, 49f, 65f, 45f, 70f, 45),
    DEWGONG(Type.WATER, Type.ICE, 90f, 49f, 65f, 70f, 95f, 70),
    GRIMER(Type.POISON, 80f, 49f, 65f, 40f, 50f, 25),
    MUK(Type.POISON, 105f, 49f, 65f, 65f, 100f, 50),
    SHELLDER(Type.WATER, 30f, 49f, 65f, 45f, 25f, 40),
    CLOYSTER(Type.WATER, Type.ICE, 50f, 49f, 65f, 85f, 45f, 70),
    GASTLY(Type.GHOST, Type.POISON, 30f, 49f, 65f, 100f, 35f, 80),
    HAUNTER(Type.GHOST, Type.POISON, 45f, 49f, 65f, 115f, 55f, 95),
    GENGAR(Type.GHOST, Type.POISON, 60f, 49f, 65f, 130f, 75f, 110),
    ONIX(Type.ROCK, Type.GROUND, 35f, 49f, 65f, 30f, 45f, 70),
    DROWZEE(Type.PSYCHIC, 60f, 49f, 65f, 43f, 90f, 42),
    HYPNO(Type.PSYCHIC, 85f, 49f, 65f, 73f, 115f, 67),
    KRABBY(Type.WATER, 30f, 49f, 65f, 25f, 25f, 50),
    KINGLER(Type.WATER, 55f, 49f, 65f, 50f, 50f, 75),
    VOLTORB(Type.ELECTRIC, 40f, 49f, 65f, 55f, 55f, 100),
    ELECTRODE(Type.ELECTRIC, 60f, 49f, 65f, 80f, 80f, 150),
    EXEGGCUTE(Type.GRASS, Type.PSYCHIC, 60f, 49f, 65f, 60f, 45f, 40),
    EXEGGUTOR(Type.GRASS, Type.PSYCHIC, 95f, 49f, 65f, 125f, 75f, 55),
    CUBONE(Type.GROUND, 50f, 49f, 65f, 40f, 50f, 35),
    MAROWAK(Type.GROUND, 60f, 49f, 65f, 50f, 80f, 45),
    HITMONLEE(Type.FIGHTING, 50f, 49f, 65f, 35f, 110f, 87),
    HITMONCHAN(Type.FIGHTING, 50f, 49f, 65f, 35f, 110f, 76),
    LICKITUNG(Type.NORMAL, 90f, 49f, 65f, 60f, 75f, 30),
    KOFFING(Type.POISON, 40f, 49f, 65f, 60f, 45f, 35),
    WEEZING(Type.POISON, 65f, 49f, 65f, 85f, 70f, 60),
    RHYHORN(Type.GROUND, Type.ROCK, 80f, 49f, 65f, 30f, 30f, 25),
    RHYDON(Type.GROUND, Type.ROCK, 105f, 49f, 65f, 45f, 45f, 40),
    CHANSEY(Type.NORMAL, 250f, 49f, 65f, 35f, 105f, 50),
    TANGELA(Type.GRASS, 65f, 49f, 65f, 100f, 40f, 60),
    KANGASKHAN(Type.NORMAL, 105f, 49f, 65f, 40f, 80f, 90),
    HORSEA(Type.WATER, 30f, 49f, 65f, 70f, 25f, 60),
    SEADRA(Type.WATER, 55f, 49f, 65f, 95f, 45f, 85),
    GOLDEEN(Type.WATER, 45f, 49f, 65f, 35f, 50f, 63),
    SEAKING(Type.WATER, 80f, 49f, 65f, 65f, 80f, 68),
    STARYU(Type.WATER, 30f, 49f, 65f, 70f, 55f, 85),
    STARMIE(Type.WATER, Type.PSYCHIC, 60f, 49f, 65f, 100f, 85f, 115),
    MR_MIME(Type.PSYCHIC, Type.FAIRY, 40f, 49f, 65f, 100f, 120f, 90),
    SCYTHER(Type.BUG, Type.FLYING, 70f, 49f, 65f, 55f, 80f, 105),
    JYNX(Type.ICE, Type.PSYCHIC, 65f, 49f, 65f, 115f, 95f, 95),
    ELECTABUZZ(Type.ELECTRIC, 65f, 49f, 65f, 95f, 85f, 105),
    MAGMAR(Type.FIRE, 65f, 49f, 65f, 100f, 85f, 93),
    PINSIR(Type.BUG, 65f, 49f, 65f, 55f, 70f, 85),
    TAUROS(Type.NORMAL, 75f, 49f, 65f, 40f, 70f, 110),
    MAGIKARP(Type.WATER, 20f, 49f, 65f, 15f, 20f, 80),
    GYARADOS(Type.WATER, Type.FLYING, 95f, 49f, 65f, 60f, 100f, 81),
    LAPRAS(Type.WATER, Type.ICE, 130f, 49f, 65f, 85f, 95f, 60),
    DITTO(Type.NORMAL, 48f, 49f, 65f, 48f, 48f, 48),
    EEVEE(Type.NORMAL, 55f, 49f, 65f, 45f, 65f, 55),
    VAPOREON(Type.WATER, 130f, 49f, 65f, 110f, 95f, 65),
    JOLTEON(Type.ELECTRIC, 65f, 49f, 65f, 110f, 95f, 130),
    FLAREON(Type.FIRE, 65f, 49f, 65f, 95f, 110f, 65),
    PORYGON(Type.NORMAL, 65f, 49f, 65f, 85f, 75f, 40),
    OMANYTE(Type.ROCK, Type.WATER, 35f, 49f, 65f, 90f, 55f, 35),
    OMASTAR(Type.ROCK, Type.WATER, 70f, 49f, 65f, 115f, 70f, 55),
    KABUTO(Type.ROCK, Type.WATER, 30f, 49f, 65f, 55f, 45f, 55),
    KABUTOPS(Type.ROCK, Type.WATER, 60f, 49f, 65f, 65f, 70f, 80),
    AERODACTYL(Type.ROCK, Type.FLYING, 80f, 49f, 65f, 60f, 75f, 130),
    SNORLAX(Type.NORMAL, 160f, 49f, 65f, 65f, 110f, 30),
    ARTICUNO(Type.ICE, Type.FLYING, 90f, 49f, 65f, 95f, 125f, 85),
    ZAPDOS(Type.ELECTRIC, Type.FLYING, 90f, 49f, 65f, 125f, 90f, 100),
    MOLTRES(Type.FIRE, Type.FLYING, 90f, 49f, 65f, 125f, 85f, 90),
    DRATINI(Type.DRAGON, 41f, 49f, 65f, 50f, 50f, 50),
    DRAGONAIR(Type.DRAGON, 61f, 49f, 65f, 70f, 70f, 70),
    DRAGONITE(Type.DRAGON, Type.FLYING, 91f, 49f, 65f, 100f, 100f, 80),
    MEWTWO(Type.PSYCHIC, 106f, 49f, 65f, 154f, 90f, 130),
    MEW(Type.PSYCHIC, 100f, 49f, 65f, 100f, 100f, 100),
    CHIKORITA(Type.GRASS, 45f, 49f, 65f, 49f, 65f, 45),
    BAYLEEF(Type.GRASS, 60f, 49f, 65f, 63f, 80f, 60),
    MEGANIUM(Type.GRASS, 80f, 49f, 65f, 83f, 100f, 80),
    CYNDAQUIL(Type.FIRE, 39f, 49f, 65f, 60f, 50f, 65),
    QUILAVA(Type.FIRE, 58f, 49f, 65f, 80f, 65f, 80),
    TYPHLOSION(Type.FIRE, 78f, 49f, 65f, 109f, 85f, 100),
    TOTODILE(Type.WATER, 50f, 49f, 65f, 44f, 48f, 43),
    CROCONAW(Type.WATER, 65f, 49f, 65f, 59f, 63f, 58),
    FERALIGATR(Type.WATER, 85f, 49f, 65f, 79f, 83f, 78),
    SENTRET(Type.NORMAL, 35f, 49f, 65f, 35f, 45f, 20),
    FURRET(Type.NORMAL, 85f, 49f, 65f, 45f, 55f, 90),
    HOOTHOOT(Type.NORMAL, Type.FLYING, 60f, 49f, 65f, 36f, 56f, 50),
    NOCTOWL(Type.NORMAL, Type.FLYING, 100f, 49f, 65f, 86f, 96f, 70),
    LEDYBA(Type.BUG, Type.FLYING, 40f, 49f, 65f, 40f, 80f, 55),
    LEDIAN(Type.BUG, Type.FLYING, 55f, 49f, 65f, 55f, 110f, 85),
    SPINARAK(Type.BUG, Type.POISON, 40f, 49f, 65f, 40f, 40f, 30),
    ARIADOS(Type.BUG, Type.POISON, 70f, 49f, 65f, 60f, 70f, 40),
    CROBAT(Type.POISON, Type.FLYING, 85f, 49f, 65f, 70f, 80f, 130),
    CHINCHOU(Type.WATER, Type.ELECTRIC, 75f, 49f, 65f, 56f, 56f, 67),
    LANTURN(Type.WATER, Type.ELECTRIC, 125f, 49f, 65f, 76f, 76f, 67),
    PICHU(Type.ELECTRIC, 20f, 49f, 65f, 35f, 35f, 60),
    CLEFFA(Type.FAIRY, 50f, 49f, 65f, 45f, 55f, 15),
    IGGLYBUFF(Type.NORMAL, Type.FAIRY, 90f, 49f, 65f, 40f, 20f, 15),
    TOGEPI(Type.FAIRY, 35f, 49f, 65f, 40f, 65f, 20),
    TOGETIC(Type.FAIRY, Type.FLYING, 55f, 49f, 65f, 80f, 105f, 40),
    NATU(Type.PSYCHIC, Type.FLYING, 40f, 49f, 65f, 70f, 45f, 70),
    XATU(Type.PSYCHIC, Type.FLYING, 65f, 49f, 65f, 95f, 70f, 95),
    MAREEP(Type.ELECTRIC, 55f, 49f, 65f, 65f, 45f, 35),
    FLAAFFY(Type.ELECTRIC, 70f, 49f, 65f, 80f, 60f, 45),
    AMPHAROS(Type.ELECTRIC, 90f, 49f, 65f, 115f, 90f, 55),
    BELLOSSOM(Type.GRASS, 75f, 49f, 65f, 90f, 100f, 50),
    MARILL(Type.WATER, Type.FAIRY, 70f, 49f, 65f, 20f, 50f, 40),
    AZUMARILL(Type.WATER, Type.FAIRY, 100f, 49f, 65f, 60f, 80f, 50),
    SUDOWOODO(Type.ROCK, 70f, 49f, 65f, 30f, 65f, 30),
    POLITOED(Type.WATER, 90f, 49f, 65f, 90f, 100f, 70),
    HOPPIP(Type.GRASS, Type.FLYING, 35f, 49f, 65f, 35f, 55f, 50),
    SKIPLOOM(Type.GRASS, Type.FLYING, 55f, 49f, 65f, 45f, 65f, 80),
    JUMPLUFF(Type.GRASS, Type.FLYING, 75f, 49f, 65f, 55f, 95f, 110),
    AIPOM(Type.NORMAL, 55f, 49f, 65f, 40f, 55f, 85),
    SUNKERN(Type.GRASS, 30f, 49f, 65f, 30f, 30f, 30),
    SUNFLORA(Type.GRASS, 75f, 49f, 65f, 105f, 85f, 30),
    YANMA(Type.BUG, Type.FLYING, 65f, 49f, 65f, 75f, 45f, 95),
    WOOPER(Type.WATER, Type.GROUND, 55f, 49f, 65f, 25f, 25f, 15),
    QUAGSIRE(Type.WATER, Type.GROUND, 95f, 49f, 65f, 65f, 65f, 35),
    ESPEON(Type.PSYCHIC, 65f, 49f, 65f, 130f, 95f, 110),
    UMBREON(Type.DARK, 95f, 49f, 65f, 60f, 130f, 65),
    MURKROW(Type.DARK, Type.FLYING, 60f, 49f, 65f, 85f, 42f, 91),
    SLOWKING(Type.WATER, Type.PSYCHIC, 95f, 49f, 65f, 100f, 110f, 30),
    MISDREAVUS(Type.GHOST, 60f, 49f, 65f, 85f, 85f, 85),
    UNOWN(Type.PSYCHIC, 48f, 49f, 65f, 72f, 48f, 48),
    WOBBUFFET(Type.PSYCHIC, 190f, 49f, 65f, 33f, 58f, 33),
    GIRAFARIG(Type.NORMAL, Type.PSYCHIC, 70f, 49f, 65f, 90f, 65f, 85),
    PINECO(Type.BUG, 50f, 49f, 65f, 35f, 35f, 15),
    FORRETRESS(Type.BUG, Type.STEEL, 75f, 49f, 65f, 60f, 60f, 40),
    DUNSPARCE(Type.NORMAL, 100f, 49f, 65f, 65f, 65f, 45),
    GLIGAR(Type.GROUND, Type.FLYING, 65f, 49f, 65f, 35f, 65f, 85),
    STEELIX(Type.STEEL, Type.GROUND, 75f, 49f, 65f, 55f, 65f, 30),
    SNUBBULL(Type.FAIRY, 60f, 49f, 65f, 40f, 40f, 30),
    GRANBULL(Type.FAIRY, 90f, 49f, 65f, 60f, 60f, 45),
    QWILFISH(Type.WATER, Type.POISON, 65f, 49f, 65f, 55f, 55f, 85),
    SCIZOR(Type.BUG, Type.STEEL, 70f, 49f, 65f, 55f, 80f, 65),
    SHUCKLE(Type.BUG, Type.ROCK, 20f, 49f, 65f, 10f, 230f, 5),
    HERACROSS(Type.BUG, Type.FIGHTING, 80f, 49f, 65f, 40f, 95f, 85),
    SNEASEL(Type.DARK, Type.ICE, 55f, 49f, 65f, 35f, 75f, 115),
    TEDDIURSA(Type.NORMAL, 60f, 49f, 65f, 50f, 50f, 40),
    URSARING(Type.NORMAL, 90f, 49f, 65f, 75f, 75f, 55),
    SLUGMA(Type.FIRE, 40f, 49f, 65f, 70f, 40f, 20),
    MAGCARGO(Type.FIRE, Type.ROCK, 60f, 49f, 65f, 90f, 80f, 30),
    SWINUB(Type.ICE, Type.GROUND, 50f, 49f, 65f, 30f, 30f, 50),
    PILOSWINE(Type.ICE, Type.GROUND, 100f, 49f, 65f, 60f, 60f, 50),
    CORSOLA(Type.WATER, Type.ROCK, 65f, 49f, 65f, 65f, 95f, 35),
    REMORAID(Type.WATER, 35f, 49f, 65f, 65f, 35f, 65),
    OCTILLERY(Type.WATER, 75f, 49f, 65f, 105f, 75f, 45),
    DELIBIRD(Type.ICE, Type.FLYING, 45f, 49f, 65f, 65f, 45f, 75),
    MANTINE(Type.WATER, Type.FLYING, 85f, 49f, 65f, 80f, 140f, 70),
    SKARMORY(Type.STEEL, Type.FLYING, 65f, 49f, 65f, 40f, 70f, 70),
    HOUNDOUR(Type.DARK, Type.FIRE, 45f, 49f, 65f, 80f, 50f, 65),
    HOUNDOOM(Type.DARK, Type.FIRE, 75f, 49f, 65f, 110f, 80f, 95),
    KINGDRA(Type.WATER, Type.DRAGON, 75f, 49f, 65f, 95f, 95f, 85),
    PHANPY(Type.GROUND, 90f, 49f, 65f, 40f, 40f, 40),
    DONPHAN(Type.GROUND, 90f, 49f, 65f, 60f, 60f, 50),
    PORYGON2(Type.NORMAL, 85f, 49f, 65f, 105f, 95f, 60),
    STANTLER(Type.NORMAL, 73f, 49f, 65f, 85f, 65f, 85),
    SMEARGLE(Type.NORMAL, 55f, 49f, 65f, 20f, 45f, 75),
    TYROGUE(Type.FIGHTING, 35f, 49f, 65f, 35f, 35f, 35),
    HITMONTOP(Type.FIGHTING, 50f, 49f, 65f, 35f, 110f, 70),
    SMOOCHUM(Type.ICE, Type.PSYCHIC, 45f, 49f, 65f, 85f, 65f, 65),
    ELEKID(Type.ELECTRIC, 45f, 49f, 65f, 65f, 55f, 95),
    MAGBY(Type.FIRE, 45f, 49f, 65f, 70f, 55f, 83),
    MILTANK(Type.NORMAL, 95f, 49f, 65f, 40f, 70f, 100),
    BLISSEY(Type.NORMAL, 255f, 49f, 65f, 75f, 135f, 55),
    RAIKOU(Type.ELECTRIC, 90f, 49f, 65f, 115f, 100f, 115),
    ENTEI(Type.FIRE, 115f, 49f, 65f, 90f, 75f, 100),
    SUICUNE(Type.WATER, 100f, 49f, 65f, 90f, 115f, 85),
    LARVITAR(Type.ROCK, Type.GROUND, 50f, 49f, 65f, 45f, 50f, 41),
    PUPITAR(Type.ROCK, Type.GROUND, 70f, 49f, 65f, 65f, 70f, 51),
    TYRANITAR(Type.ROCK, Type.DARK, 100f, 49f, 65f, 95f, 100f, 61),
    LUGIA(Type.PSYCHIC, Type.FLYING, 106f, 49f, 65f, 90f, 154f, 110),
    HO_OH(Type.FIRE, Type.FLYING, 106f, 49f, 65f, 110f, 154f, 90);

    private final Type type1;
    private final Type type2;
    private final float hp;
    private final float attack;
    private final float defense;
    private final float spattack;
    private final float spDefense;
    private final float speed;

    BaseStats(Type type1, Type type2, float hp, float attack, float defense, float spattack, float spDefense, float speed) {
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spDefense = spDefense;
        this.speed = speed;
    }

    BaseStats(Type type, float hp, float attack, float defense, float spattack, float spDefense, float speed) {
        this.type1 = type;
        this.type2 = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spDefense = spDefense;
        this.speed = speed;
    }
    public String getName(){
        return name().substring(0,1) + name().substring(1).toLowerCase();
    }

    public Type getType1() {
        return type1;
    }

    public Type getType2() {
        return type2;
    }

    public float getHp() {
        return hp;
    }

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public float getSpattack() {
        return spattack;
    }

    public float getSpDefense() {
        return spDefense;
    }

    public float getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name().substring(0,1) + name().substring(1).toLowerCase();
    }

}

    