export interface MarkerData {
  id: number;
  position: { lat: number; lng: number };
  problem: string;
  address?: string;
}