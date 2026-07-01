import { Salle } from "./salle";

export interface Filiere {
  id: number;
  libelle: string;
  debut: string;
  fin: string;
  salle?: Salle;
}
